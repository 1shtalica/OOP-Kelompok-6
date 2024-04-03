package staff;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adria
 */
public class PatientList {
     private final String pengurus;
    private Patient[] daftar;
    private int count = 0;
    
    public PatientList(String pengurus) {
        this.pengurus = pengurus;
    }
    
    public void daftarPasien() {
        for (Patient pasien : this.daftar) {
            System.out.println("Nama Pengurus = " + this.pengurus);
            System.out.println("Nama Pasien = " + pasien.getNama());
            System.out.println("Alamat Pasien = " + pasien.getAlamat());
            System.out.println("Kontak Pasien = " + pasien.getKontak());
            System.out.println("Asuransi Pasien = " + pasien.getAsuransi());
        }
    }
    
    public void insertPasien(Patient pasien) {
        this.daftar[this.count] = pasien;
        this.count++;
    }
}

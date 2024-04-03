/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff;

/**
 *
 * @author adria
 */
public class Patient {
    private String nama;
    private String alamat;
    private String kontak;
    private String asuransi;
    
    public Patient(String nama, String alamat, String kontak, String asuransi) {
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
        this.asuransi = asuransi;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getAlamat() {
        return this.alamat;
    }
    
    public String getKontak() {
        return this.kontak;
    }
    
    public String getAsuransi() {
        return this.asuransi;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    
    public void setAsuransi(String asuransi) {
        this.asuransi = asuransi;
    }
}

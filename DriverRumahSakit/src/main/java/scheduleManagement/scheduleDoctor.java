/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scheduleManagement;

import scheduleManagement.EditSchedule;
import user.Doctor;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import user.Patient;

/**
 *
 * @author adibf
 */
public class scheduleDoctor {
    private String idSchedule;
    private Doctor doctor;
    private String day;
    private int maxPatient;
    private Patient[] patients;
    
    private String pilihanFilter;
    
    List<Doctor> daftarDokter;
    List<EditSchedule> daftarJadwal;
    
    //=====================================================
    
    Scanner scanner =  new Scanner(System.in);

   // public Shecdule(String idSchedule, Doctor doctor, String date, int maxPatient, Patient[] patients) {
     //   this.idSchedule = idSchedule;
       // this.doctor = doctor;
        //this.date = date;
        //this.maxPatient = maxPatient;
        //this.patients = patients;
    //}
    
    int idx = 1;
    public void addSchedule(Map<Doctor, String> doctor) {
        List<Map.Entry<Doctor, String>> entryList = new ArrayList<>(doctor.entrySet());

        
        for (Map.Entry<Doctor, String> entry : entryList) {
            Doctor key = entry.getKey();
            System.out.println(idx + ". " + key.getName());
            idx++;
        }

       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the corresponding number:");
        int chosenIndex = scanner.nextInt();

        
        if (chosenIndex >= 0 && chosenIndex < entryList.size()) {
            Map.Entry<Doctor, String> chosenEntry = entryList.get(chosenIndex);
            Doctor chosenDoctor = chosenEntry.getKey();
            String schedule = chosenEntry.getValue();
            
            
            System.out.println("You chose: " + chosenDoctor.getName() + " with schedule: " + schedule);
       this.doctor = chosenDoctor;
        } else {
            System.out.println("Invalid index chosen.");
        }
        
        System.out.println(this.doctor.getName());
    }
    
    
    //=====================================================

    public scheduleDoctor(Doctor dokter, String pilihanFilter, List<Doctor> daftarDokter, List<EditSchedule> daftarJadwal) {
        this.doctor = dokter;
        this.pilihanFilter = pilihanFilter;
        this.daftarDokter = daftarDokter;
        this.daftarJadwal = daftarJadwal;
    }
    
    //==========Check Section==========
    
    public boolean cekNamaDokter(String nama){
        for (Doctor dokter : daftarDokter){
            if (dokter.getUsername().equalsIgnoreCase(nama)){
                return true;
            } 
        }
        return false;
    }
    
    public boolean cekFilterKosong(String pilihanFilter){
        if (pilihanFilter == "None"){
            return true;
        } else {
            return false;
        }
    }
    
    //==========SCHEDULE SECTION==========
    
    /*
    public void searchNama(String nama){
        
    }
    
    public void filterSpecialization(){
        
        System.out.print("Masukkan pilihan filter berdasarkan tipe doctor: ");
        String pilihanFilter = scanner.nextLine();
        
        boolean kosong = cekFilterKosong(pilihanFilter);
        
        if (kosong == true){
            
        } else {
            switch (pilihanFilter) {
            case "CARDIOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah CARDIOLOGIST
                break;
            case "DENTIST":
                // Lakukan sesuatu jika spesialisasi adalah DENTIST
                break;
            case "SURGEON":
                // Lakukan sesuatu jika spesialisasi adalah SURGEON
                break;
            case "PEDIATRICIAN":
                // Lakukan sesuatu jika spesialisasi adalah PEDIATRICIAN
                break;
            case "GYNECOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah GYNECOLOGIST
                break;
            case "NEUROLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah NEUROLOGIST
                break;
            case "ORTHOPEDIC_SURGEON":
                // Lakukan sesuatu jika spesialisasi adalah ORTHOPEDIC_SURGEON
                break;
            case "PSYCHIATRIST":
                // Lakukan sesuatu jika spesialisasi adalah PSYCHIATRIST
                break;
            case "ONCOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah ONCOLOGIST
                break;
            case "DERMATOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah DERMATOLOGIST
                break;
            case "ENDOCRINOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah ENDOCRINOLOGIST
                break;
            case "GASTROENTEROLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah GASTROENTEROLOGIST
                break;
            case "UROLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah UROLOGIST
                break;
            case "OTOLARYNGOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah OTOLARYNGOLOGIST
                break;
            case "OPHTHALMOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah OPHTHALMOLOGIST
                break;
            case "RHEUMATOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah RHEUMATOLOGIST
                break;
            case "NEPHROLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah NEPHROLOGIST
                break;
            case "PULMONOLOGIST":
                // Lakukan sesuatu jika spesialisasi adalah PULMONOLOGIST
                break;
            default:
                // Lakukan sesuatu jika spesialisasi tidak dikenal
                break;
        }
        }
    }
    */
    /*
    public void printJadwal(String inputSearch, String inputFilter, List<EditSchedule> daftarJadwal){
        
        if (inputSearch.equals(" ") && inputFilter.equals(" ")) {
        for (EditSchedule jadwal : daftarJadwal) {
            System.out.println("Doctor's ID: " + jadwal.getDokter().getDoctorID());
            System.out.println("Doctor's Name: " + jadwal.getDokter().getUsername());
            System.out.println("Specialization: " + jadwal.getDokter().getDoctorType());
            System.out.println("Session: " + jadwal.getSesiDokter());
            System.out.println("Working Hour: " + jadwal.getWorkingHour());
            System.out.println("-------------------------------------");
        } else if (){
                
                }
    }
    }*/
    
    //==========Getter & Setter==========

    public Doctor getDokter() {
        return doctor;
    }

    public void setDokter(Doctor dokter) {
        this.doctor = dokter;
    }

    public String getPilihanFilter() {
        return pilihanFilter;
    }

    public void setPilihanFilter(String pilihanFilter) {
        this.pilihanFilter = pilihanFilter;
    }

    public List<Doctor> getDaftarDokter() {
        return daftarDokter;
    }

    public void setDaftarDokter(List<Doctor> daftarDokter) {
        this.daftarDokter = daftarDokter;
    }

    public List<EditSchedule> getDaftarJadwal() {
        return daftarJadwal;
    }

    public void setDaftarJadwal(List<EditSchedule> daftarJadwal) {
        this.daftarJadwal = daftarJadwal;
    }
    
}

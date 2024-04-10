package patientManagementSystem;

import staff.Patient;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adria
 */
public class PatientManagement {
    private final String nurse;
    private final Patient[] list;
    private int count = 0;
    
    public PatientManagement(String manager) {
        this.nurse = manager;
        this.list = new Patient[100];
    }
    
    public String getNurse() {
        return this.nurse;
    } 
    
    public void listPatients() {
        for (Patient patient : this.list) {
            if (patient != null) {
                System.out.println("===================================");
                System.out.println("Patient's Name = " + patient.getName());
                System.out.println("Patient's Address = " + patient.getAddress());
                System.out.println("Patient's Contact = " + patient.getContact());
                System.out.println("Patient's Insurance = " + patient.getInsurance());
                System.out.println("===================================");
            }
        }
    }
    
    public void insertPatient(Patient patient) {
        this.list[this.count] = patient;
        this.count++;
    }
}


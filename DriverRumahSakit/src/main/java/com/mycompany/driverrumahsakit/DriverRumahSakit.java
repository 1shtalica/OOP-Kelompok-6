/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.driverrumahsakit;

import userManagementSystem.UserManager;
import staff.Patient;
import patientManagementSystem.PatientManagement;

/**
 *
 * @author kevin
 */
import java.util.Scanner;
public class DriverRumahSakit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientManagement patientList = null; 

        boolean continueList = true;
        while (continueList) {
            System.out.println("Choose Options. 1) insert data patient. 2) See data patient : ");
            int options = scanner.nextInt();
            scanner.nextLine();

            if (options == 1) {
                System.out.print("Enter Nurse Name: ");
                String nurseName = scanner.nextLine();

                patientList = new PatientManagement(nurseName); 

                boolean continueInput = true;
                while (continueInput) {
                    System.out.println("Enter details for Patient:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Insurance: ");
                    String insurance = scanner.nextLine();

                    Patient patient = new Patient(name, address, contact, insurance);
                    patientList.insertPatient(patient);

                    System.out.print("Do you want to add another patient? (yes/no): ");
                    String input = scanner.nextLine();
                    if (!input.equalsIgnoreCase("yes")) {
                        continueInput = false;
                    }
                }
            } else {
                if (patientList != null) { 
                    System.out.println("\nList of Patients:");
                    System.out.println("Name Nurse : " + patientList.getNurse());
                    patientList.listPatients();
                } else {
                    System.out.println("No patient data available.");
                }
            }
        }

        scanner.close(); 
    }
}

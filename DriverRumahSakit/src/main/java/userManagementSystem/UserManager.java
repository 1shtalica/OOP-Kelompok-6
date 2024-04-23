/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userManagementSystem;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import user.Admin;
import user.Doctor;
import user.HospitalSystem;
import user.Patient;
import user.UserType;

/**
 *
 * @author kevin
 */
public class UserManager {
    private Map<Patient, String> patients;
    private Map<Admin, String> admins;
    private Map<Doctor, String> doctors;
    private Scanner scanner;
    private Scanner scannerInt;

    
   
    public void adminMenu(Admin admin){
         HospitalSystem <Admin>hospitalSystem = new  HospitalSystem<>(admin, patients, admins, doctors);
        Scanner scannerInt = new Scanner(System.in);
        int choice = -1;
        
        while(choice != 0){

            System.out.println("welcome" + admin.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+ admin.getUserType());
            System.out.println("1. add new patient");
            System.out.println("2. add new doctor");
            System.out.println("3. Remove Patient");
            System.out.println("4. Remove doctor");
            System.out.println("5. Update this data");
            System.out.println("6. View Admin");
            System.out.println("7. View Patients");
            System.out.println("8. View Doctors");
            System.out.println("9. Delete this account");
            
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("0. logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                patients = admin.addNewPatient(patients);
                break;
                case 2:
                doctors = admin.addNewDoctor(doctors);
                break;
                case 3:
                System.out.print("Enter patient's username to remove: ");
                String username = scanner.nextLine();
                hospitalSystem.deletePatientsData(username, patients);
                break;
                case 4:
                System.out.print("Enter doctor's username to remove: ");
                username = scanner.nextLine();
                hospitalSystem.deleteDoctorsData(username, doctors);
                break;
                case 5:
                  // Farhan 
                break;
                case 6:
                  for(Admin admin1: admins.keySet()) {
                       System.out.println("name: "+admin1.getName());
                       System.out.println("email: "+admin1.getEmail());
                       System.out.println("id: "+admin1.getAdminID());
                       System.out.println("phonenumber: "+admin1.getPhoneNumber());
                       System.out.println("username: "+admin1.getUsername()); 
                  }
                break;
                case 7:
                  System.out.println("Patient List");
                  for(Patient patient: patients.keySet()) {
                      System.out.println("Patient ID: " + patient.getPatientID());
                      System.out.println("Full Name: " + patient.getName());
                      System.out.println("Username: " + patient.getUsername());
                      System.out.println("Email: " + patient.getEmail());
                      System.out.println("Phone Number: " + patient.getPhoneNumber());
                      System.out.println("Birth Date: " + patient.getBirtDate());
                      System.out.println("Gender: " + patient.getGender().name());
                      System.out.println("Address: " + patient.getAddress());
                      System.out.println("Blood Type: " + patient.getBloodType().name());

                  }
                break;
                case 8:
                    System.out.println("Doctor List");
                    for(Doctor doctor: doctors.keySet()) {
                       System.out.println("Username: " + doctor.getUsername());
                       System.out.println("Full Name: " + doctor.getName());
                       System.out.println("Doctor ID: " + doctor.getDoctorID());
                       System.out.println("Phone Number: " + doctor.getPhoneNumber());
                       System.out.println("Email: " + doctor.getEmail());
                       System.out.println("Birth Date: " + doctor.getBirtDate());
                       System.out.println("Gender: " + doctor.getGender());
                       System.out.println("Address: " + doctor.getAddress());
                       System.out.println("Doctor Type: " + doctor.getDoctorType()); 
                    }
                break;
                case 9:
                 hospitalSystem.removeAdmins(admin);
                 choice = 0; 
                break;
                
                case 0:                            
                System.out.println("Logout successful!");
                break;
                default:
                System.out.println("Invalid option. Please choose again.");
        }
            
        }
        
    }
    public void patientMenu(Patient patient){
        
        Scanner scannerInt = new Scanner(System.in);
        HospitalSystem <Patient>hospitalSystem = new  HospitalSystem<>(patient, patients, admins, doctors);
        int choice = 0;
        
        while(choice != 6){
            
            System.out.println("welcome" +patient.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+patient.getUserType());
            System.out.println("1. View Data ");
            System.out.println("2. Update Data ");
            System.out.println("3. Remove Data ");
            System.out.println("4. View Doctor ");
            System.out.println("5. Book Of Appointment Patiens");
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("6. logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //tambahanin disini sesuai dengan fitur masing masing
            switch (choice) {
                case 1:
                patient.listofPatient(patients);
                break;
                case 2:
                   // farhan 
                break;
                    
                case 3:
                 hospitalSystem.removePatients(patient);
                 choice = 6;
                break;
                
                case 4:
                System.out.println("Doctor List");
                   for(Doctor doctor: doctors.keySet()) {
                       System.out.println("Username: " + doctor.getUsername());
                       System.out.println("Full Name: " + doctor.getName());
                       System.out.println("Doctor ID: " + doctor.getDoctorID());
                       System.out.println("Phone Number: " + doctor.getPhoneNumber());
                       System.out.println("Email: " + doctor.getEmail());
                       System.out.println("Birth Date: " + doctor.getBirtDate());
                       System.out.println("Gender: " + doctor.getGender());
                       System.out.println("Address: " + doctor.getAddress());
                       System.out.println("Doctor Type: " + doctor.getDoctorType());
                   }
                break;
                case 5:
                //Adib
                break;
                
                case 6:                            
                System.out.println("Logout successful!");
                break;
                default:
                System.out.println("Invalid option. Please choose again.");
        }
        
        
            
        }
    }
    public void doctorMenu(Doctor doctor){
        Scanner scannerInt = new Scanner(System.in);
        int choice = 0;
        
        while(choice != 5){

            System.out.println("welcome" +doctor.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+doctor.getUserType());
            System.out.println("1. View Data ");
            System.out.println("2. Updated Data");
            System.out.println("3. View Pasien ");
            System.out.println("4. Book of  Appointment Doctors");
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("5. logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //tambahanin disini sesuai dengan fitur masing masing
            switch (choice) {
                case 1:
                for(Doctor doctor1: doctors.keySet()) {
                       System.out.println("Username: " + doctor1.getUsername());
                       System.out.println("Full Name: " + doctor1.getName());
                       System.out.println("Doctor ID: " + doctor1.getDoctorID());
                       System.out.println("Phone Number: " + doctor1.getPhoneNumber());
                       System.out.println("Email: " + doctor1.getEmail());
                       System.out.println("Birth Date: " + doctor1.getBirtDate());
                       System.out.println("Gender: " + doctor1.getGender());
                       System.out.println("Address: " + doctor1.getAddress());
                       System.out.println("Doctor Type: " + doctor1.getDoctorType());
                }
                break;
                case 2:
                // farhan
                break;
                
                case 3:
                System.out.println("Patient List");
                  for(Patient patient: patients.keySet()) {
                      System.out.println("Patient ID: " + patient.getPatientID());
                      System.out.println("Full Name: " + patient.getName());
                      System.out.println("Username: " + patient.getUsername());
                      System.out.println("Email: " + patient.getEmail());
                      System.out.println("Phone Number: " + patient.getPhoneNumber());
                      System.out.println("Birth Date: " + patient.getBirtDate());
                      System.out.println("Gender: " + patient.getGender().name());
                      System.out.println("Address: " + patient.getAddress());
                      System.out.println("Blood Type: " + patient.getBloodType().name());
                  }   
                break;
                case 4:
                //Adib5
                break;
                
                case 5:                            
                System.out.println("Logout successful!");
                break;
                default:
                System.out.println("Invalid option. Please choose again.");
        }
        
        
            
        }
    }
     public UserManager() {
        this.admins = new HashMap<>();
        this.patients = new HashMap<>();
        this.doctors = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.scannerInt = new Scanner(System.in);
         Admin admin1 = new Admin("admin","admin kevin","082312312",UserType.Admin,"admin1@gmail.com");
        admins.put(admin1, "admin123");    
    }
     
     public void displayMenu(){
         
        Patient patient = new Patient(null,null,null,null,null,null,null,null,null,null);
        Admin admin = new Admin(null,null,null,null,null);
        Doctor doctor = new Doctor(null,null,null,null,null,null,null,null,null,null);
        boolean running = true;
            while (running) {
        System.out.println("Menu:");
        System.out.println("1. Register as Patient");
        System.out.println("2. Login as Patient");
        System.out.println("3. Login as Admin");
        System.out.println("4. Login as Doctor");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scannerInt.nextInt();
        scannerInt.nextLine(); 
        switch (choice) {
            case 1:
                patients = patient.Register(patients);
                
                break;
            case 2:               
                Patient loggedInPatient = patient.login(patients);
                if (loggedInPatient != null) {
                     patientMenu(loggedInPatient);
                }               
                break;
            case 3:             
                Admin loggedInAdmin = admin.login(admins);
                if (loggedInAdmin != null) {
                     adminMenu(loggedInAdmin);
                     
                }
                
                break;
            case 4:               
                Doctor loggedInDoctor = doctor.login(doctors);
                if (loggedInDoctor != null) {
                     doctorMenu(loggedInDoctor);
                }
                
                break;
            case 5:
                
                running = false;
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
     }
     }
     
}
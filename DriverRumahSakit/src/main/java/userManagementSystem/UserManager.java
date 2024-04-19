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
        Scanner scannerInt = new Scanner(System.in);
        int choice = 0;
        
        while(choice != 4){

            System.out.println("welcome" +admin.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+admin.getUserType());
            System.out.println("1. add new patient");
            System.out.println("2. add new doctor");
            System.out.println("3. add new admin");
            
            
            System.out.println("name: "+admin.getName());
            System.out.println("email: "+admin.getEmail());
            System.out.println("id: "+admin.getAdminID());
            System.out.println("phonenumber: "+admin.getPhoneNumber());
            System.out.println("username: "+admin.getUsername());
            
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("4. logout");
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
                 admins = admin.addNewAdmin(admins);
                break;
                case 4:                            
                System.out.println("Logout successful!");
                break;
                default:
                System.out.println("Invalid option. Please choose again.");
        }
        
        
            
        }
        
    }
    public void patientMenu(Patient patient){
        Scanner scannerInt = new Scanner(System.in);
        int choice = 0;
        
        while(choice != 4){
            
            System.out.println("name: "+patient.getName());
            System.out.println("address: "+patient.getAddress());
            System.out.println("birtdate: "+patient.getBirtDate());
            System.out.println("email: "+patient.getEmail());
            System.out.println("address: "+patient.getPatientID());
            System.out.println("phone: "+patient.getPhoneNumber());
            System.out.println("username: "+patient.getUsername());
            System.out.println("bloodtype: "+patient.getBloodType());
            System.out.println("gender: "+patient.getGender());
            System.out.println("type: "+patient.getUserType());
            

            System.out.println("welcome" +patient.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+patient.getUserType());
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("4. logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //tambahanin disini sesuai dengan fitur masing masing
            switch (choice) {
                case 1:
                
                break;
                case 2:
                
                break;
                
               
                case 3:
                 
                break;
                case 4:                            
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
        
        
        System.out.println("address: "+doctor.getAddress());
        System.out.println("birtdate: "+doctor.getBirtDate());
        System.out.println("id: "+doctor.getDoctorID());
        System.out.println("email: "+doctor.getEmail());
        System.out.println("name: "+doctor.getName());
        System.out.println("phonenumber: "+doctor.getPhoneNumber());
        System.out.println("username: "+doctor.getUsername());
        System.out.println("doctor type: "+doctor.getDoctorType());
        System.out.println("gender: "+doctor.getGender());
        System.out.println("user type: "+doctor.getUserType());
        
        while(choice != 4){

            System.out.println("welcome" +doctor.getUsername()+ " to rindang hospital");
            System.out.println("you are login as "+doctor.getUserType());
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            
            //tambahanin disini sesuai dengan fitur masing masing
            System.out.println("4. logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //tambahanin disini sesuai dengan fitur masing masing
            switch (choice) {
                case 1:
                
                break;
                case 2:
                
                break;
                
               
                case 3:
                 
                break;
                case 4:                            
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
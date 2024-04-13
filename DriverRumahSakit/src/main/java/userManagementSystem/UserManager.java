/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userManagementSystem;


import java.util.*;

import user.User;

import user.HospitalSystem;
import user.Admin;
import user.Patient;
import user.UserType;

/**
 *
 * @author kevin
 */
public class UserManager {
    private Map<User, String> userCredentials;
    private Scanner scanner;
    private Scanner scannerInt;
    
    
     public UserManager() {
        this.userCredentials = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.scannerInt = new Scanner(System.in);
         Admin admin1 = new Admin("admin","082312312",UserType.Admin,"admin1@gmail.com");
        userCredentials.put(admin1, "admin123");
        
        
        
    }
     private String generatePatientId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void registerPatient() {
        System.out.println("Registration Form");
        String username = "";
        String email= "";
        String phoneNumber="";
        int age;
        String password;
        String patientID = generatePatientId();
        boolean existUser = true;
        
        
        while (existUser) {            
             System.out.print("Enter your username: ");
             username = scanner.nextLine();
             existUser = false;
             for (User existingUser : userCredentials.keySet()) {
                if (existingUser.getUsername().equals(username)) {
                    existUser = true;
                    System.out.print("username already exist ");
                    System.out.print("please enter another username ");
                    break;
                }
             
             }
        }
        existUser = true;
        while (existUser) {            
             System.out.print("Enter your Email: ");
             email = scanner.nextLine();
             existUser = false;
             for (User existingUser : userCredentials.keySet()) {
                if (existingUser.getEmail().equals(email)) {
                    existUser = true; 
                    System.out.print("Email already exist ");
                    System.out.print("please enter another Email ");
                    break;
                }
             
             }
        }
        existUser = true;
        while (existUser) {            
             System.out.print("Enter your phone number: ");
             phoneNumber = scanner.nextLine();
             existUser = false;
             for (User existingUser : userCredentials.keySet()) {
                if (existingUser.getPhoneNumber().equals(phoneNumber)) {
                    existUser = true;
                    System.out.print("phone number already exist ");
                    System.out.print("please enter another phone number ");
                    break;
                }
             
             }
        }
        System.out.print("enter your age: ");
        age =  scannerInt.nextInt();
        System.out.print("enter your password: ");
        password =  scanner.nextLine();
        
        
        
        Patient patient = new Patient(age,patientID,username,phoneNumber,UserType.Patient,email);
        userCredentials.put(patient, password);
        
    }
    
    public void login() {
    boolean loggedIn = false;
    String username = "";
    String password = "";

    while (!loggedIn) {
        System.out.println("Login Form");
        System.out.println("Enter your username: ");
         username = scanner.nextLine();
        System.out.println("Enter your password: ");
         password = scanner.nextLine();

        for (Map.Entry<User, String> entry : userCredentials.entrySet()) {
            User user = entry.getKey();
            String storedPassword = entry.getValue();

           if (user.getUsername().equals(username) && storedPassword.equals(password)) {
    System.out.println("Login successful!");

    loggedIn = true;

    // Menampilkan menu sesuai dengan tipe pengguna setelah login berhasil
    switch (user.getUserType()) {
        case Patient:
            patientUserLogin(user);
            break;
        case Admin:
            adminUserLogin(user);
            break;
        case Doctor:
            doctorUserLogin(user);
            break;
        default:
            System.out.println("Unknown user type.");
            break;
    }
    break; 
}

        }

        if (!loggedIn) {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}
    
    
   public void patientUserLogin(User user) {
    boolean loggedIn = true;
    while (loggedIn) {
        System.out.println("You are logged in as " + user.getUserType());
        System.out.println("Welcome, " + user.getUsername());
        System.out.println("1. Edit username");
        System.out.println("2. Logout");
        System.out.print("Choose an option: ");
        int option = scannerInt.nextInt();
        scannerInt.nextLine(); // Membersihkan newline dari buffer

        switch (option) {
            case 1:
                ManagePatient(new HospitalSystem(), scanner);
                break;
            case 2:
                loggedIn = false; // Set loggedIn menjadi false agar loop berhenti
                System.out.println("Logout successful!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

public void ManagePatient(HospitalSystem hospitalSystem, Scanner scanner ) {
    int input;
    do {
        List<Patient> patients = hospitalSystem.getPatients();
        System.out.println("--------------------------------------------");
        System.out.println("|                   Patients                |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Add Patient");
        System.out.println("2. List of patients");
        System.out.println("3. Removed Personal Data");
        System.out.println("0. Back to Menu");
        System.out.print("Select an Option: ");

        input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1 -> {
                System.out.print("Enter patient's Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter patient's age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // consume the newline
                System.out.print("Enter patient's PatientID: ");
                String patientID = scanner.nextLine();
                System.out.print("Enter patient's phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter patient's userType: ");
                String userType = scanner.nextLine();
                System.out.print("Enter patient's email: ");
                String email = scanner.nextLine();
                Patient patient = new Patient(age, patientID, username, phoneNumber, UserType.valueOf(userType), email);
                hospitalSystem.addPatients(patient);
                hospitalSystem.pendaftaranMedicalCheckUp(patient);
            }
            case 2 -> {
                System.out.println("List of Patient: ");
                hospitalSystem.getAll();
            }
            case 3 -> {
                System.out.print("Enter patient's ID to remove: ");
                String id = scanner.nextLine();

                Patient patient = hospitalSystem.getPatientById(id);
                if (patient != null) {
                    hospitalSystem.removePatients(patient);
                } else {
                    System.out.println("No patient found with the provided ID.");
                }

            }
            case 0 -> {
                System.out.println("Returning to the main menu.");
            }
            default -> {
                System.out.println("Invalid option. Please try again.");
            }
        }
    } while (input != 0);
}
    
    public void adminUserLogin(User user) {
    boolean loggedIn = true;
    while (loggedIn) {
        System.out.println("You are logged in as " + user.getUserType());
        System.out.println("Welcome, " + user.getUsername());
        System.out.println("1. Add admin");
        System.out.println("2. Add doctor");
        System.out.println("3. Add patient");
        System.out.println("4. Logout");
        System.out.print("Choose an option: ");
        int option = scannerInt.nextInt();
        scannerInt.nextLine(); // Membersihkan newline dari buffer

        switch (option) {
            case 1:
                // Implementasi penambahan admin
                break;
            case 2:
                // Implementasi penambahan dokter
                break;
            case 3:
                // Implementasi penambahan pasien
                break;
            case 4:
                loggedIn = false; // Set loggedIn menjadi false agar loop berhenti
                System.out.println("Logout successful!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

    
    public void doctorUserLogin(User user) {
    boolean loggedIn = true;
    while (loggedIn) {
        System.out.println("You are logged in as " + user.getUserType());
        System.out.println("Welcome, " + user.getUsername());
        System.out.println("1. Edit username");
        System.out.println("2. Logout");
        System.out.print("Choose an option: ");
        int option = scannerInt.nextInt();
        scannerInt.nextLine(); // Membersihkan newline dari buffer

        switch (option) {
            case 1:
                // Implementasi edit username
                break;
            case 2:
                loggedIn = false; // Set loggedIn menjadi false agar loop berhenti
                System.out.println("Logout successful!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

    
    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to rindang hospital");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scannerInt.nextInt();
            scannerInt.nextLine(); 

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    registerPatient();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using User Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

}
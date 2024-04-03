/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userManagementSystem;


import java.util.HashMap;
import user.User;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
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
        System.out.print("enter your password: ");
        password =  scanner.nextLine();
        System.out.print("enter your age: ");
        age =  scannerInt.nextInt();
        
        
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
                break; 
            }
        }

        if (!loggedIn) {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}

}
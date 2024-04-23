/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Admin extends User {
    private String adminID;

    public Admin( String username,String name, String phoneNumber, UserType userType, String email) {
        super(username, name , phoneNumber, userType,email);
        this.adminID = generateAdminID();
    }

    
     private String generateAdminID() {
        Random random = new Random();
        StringBuilder adminIDBuilder = new StringBuilder();

        
        for (int i = 0; i < 5; i++) {
            adminIDBuilder.append(random.nextInt(10)); 
        }

        return adminIDBuilder.toString(); 
    }
    
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    
    

    
    public Admin login(Map<Admin, String> userCredentials) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    
    
    for (Map.Entry<Admin, String> entry : userCredentials.entrySet()) {
        Admin user = entry.getKey();
        String storedPassword = entry.getValue();
        
        
        if (user.getUsername().equals(username) && storedPassword.equals(password)) {
            
            System.out.println("Login successful!");
            return user;
        }
    }
    
    
    System.out.println("Login failed. Incorrect username or password.");
    return null;
}
    
    
    public Map<Patient, String> addNewPatient (Map<Patient, String> user){
        Patient patient = new Patient(null,null,null,null,null,null,null,null,null,null);
        return patient.Register(user);
    }
    
     public Map<Doctor, String> addNewDoctor(Map<Doctor, String> user) {
    Scanner scanner = new Scanner(System.in);

   
    String doctorID ="";
    
    String username="";
    String phoneNumber="";
    String email="";

   
    boolean doctorIDExists = true;
    while (doctorIDExists) {
        System.out.print("Enter doctor ID: ");
        doctorID = scanner.nextLine();
        doctorIDExists = false;

        for (Doctor existingDoctor : user.keySet()) {
            if (existingDoctor.getDoctorID().equals(doctorID)) {
                doctorIDExists = true;
                System.out.println("Doctor ID already exists. Please enter another Doctor ID.");
                break;
            }
        }
    }
    
    System.out.print("Enter the doctor's full name: ");
    String fullName = scanner.nextLine();

    boolean usernameExists = true;
    while (usernameExists) {
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        usernameExists = false;

        for (Doctor existingDoctor : user.keySet()) {
            if (existingDoctor.getUsername().equals(username)) {
                usernameExists = true;
                System.out.println("Username already exists. Please enter another username.");
                break;
            }
        }
    }
   

    
    System.out.println("Select doctor type:");
    DoctorType[] doctorTypes = DoctorType.values();
    for (int i = 0; i < doctorTypes.length; i++) {
        System.out.println((i + 1) + ". " + doctorTypes[i].name());
    }

   
    int doctorTypeIndex = -1;
    boolean validDoctorTypeIndex = false;
    while (!validDoctorTypeIndex) {
        System.out.print("Enter the number corresponding to the doctor type: ");
        doctorTypeIndex = scanner.nextInt() - 1;

        
        if (doctorTypeIndex >= 0 && doctorTypeIndex < doctorTypes.length) {
            validDoctorTypeIndex = true;
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + doctorTypes.length + ".");
        }
    }
    scanner.nextLine(); 

    DoctorType doctorType = doctorTypes[doctorTypeIndex];

    
    

    
    boolean phoneNumberExists = true;
    while (phoneNumberExists) {
        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextLine();
        phoneNumberExists = false;

        for (Doctor existingDoctor : user.keySet()) {
            if (existingDoctor.getPhoneNumber().equals(phoneNumber)) {
                phoneNumberExists = true;
                System.out.println("Phone number already exists. Please enter another phone number.");
                break;
            }
        }
    }

    
    boolean emailExists = true;
    while (emailExists) {
        System.out.print("Enter email: ");
        email = scanner.nextLine();
        emailExists = false;

        for (Doctor existingDoctor : user.keySet()) {
            if (existingDoctor.getEmail().equals(email)) {
                emailExists = true;
                System.out.println("Email already exists. Please enter another email.");
                break;
            }
        }
    }
    
    
     DateTimeFormatter inputDateFormatter = DateTimeFormatter.ofPattern("d M uuuu");
      LocalDate birthDate = null;
       while (birthDate == null) {
            System.out.print("Enter birth date (day month year, e.g. 25 5 1990 for 25 May 1990): ");
            String input = scanner.nextLine();

            try {
                
                birthDate = LocalDate.parse(input, inputDateFormatter);
            } catch (Exception e) {

                System.out.println("Invalid date format. Please enter date in the format 'day month year' (e.g. 25 5 1990).");
            }
        }
       DateTimeFormatter outputDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String birthDateString = birthDate.format(outputDateFormatter);
       
       
       System.out.println("Enter the doctor's gender: ");
    UserGender[] userGenders = UserGender.values();
    for (int i = 0; i < userGenders.length; i++) {
        System.out.println((i + 1) + ". " + userGenders[i].name());
    }

   
    int userGenderIndex = -1;
    boolean validUserGenderIndex = false;
    while (!validUserGenderIndex) {
        System.out.print("Enter the number corresponding to the gender type: ");
        userGenderIndex = scanner.nextInt() - 1;

        
        if (userGenderIndex >= 0 && userGenderIndex < userGenders.length) {
            validUserGenderIndex = true;
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + userGenders.length + ".");
        }
    }
    scanner.nextLine(); 

    UserGender userGender = userGenders[userGenderIndex];
    
    System.out.print("Enter the doctor's address: ");
    String doctorAddress = scanner.nextLine();
       
    
    Doctor newDoctor = new Doctor(doctorID,fullName, doctorType, username, phoneNumber, UserType.Doctor, email,birthDateString,userGender,doctorAddress);

    
    System.out.print("Enter password for the new doctor: ");
    String password = scanner.nextLine();

    user.put(newDoctor, password);

    System.out.println("New doctor added successfully.");
    return user;
    }
     
     
     
     
     public Map<Admin, String> addNewAdmin(Map<Admin, String> user){
         
         Scanner scanner = new Scanner(System.in);

   
    String username ="";
    String phoneNumber="";
    String email = "";

    
    boolean usernameExists = true;
    while (usernameExists) {
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        usernameExists = false;

        for (Admin existingAdmin : user.keySet()) {
            if (existingAdmin.getUsername().equals(username)) {
                usernameExists = true;
                System.out.println("Username already exists. Please enter another username.");
                break;
            }
        }
    }
    
     System.out.print("Enter admin full name: ");
    String fullName = scanner.nextLine();

    
    boolean phoneNumberExists = true;
    while (phoneNumberExists) {
        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextLine();
        phoneNumberExists = false;

        for (Admin existingAdmin : user.keySet()) {
            if (existingAdmin.getPhoneNumber().equals(phoneNumber)) {
                phoneNumberExists = true;
                System.out.println("Phone number already exists. Please enter another phone number.");
                break;
            }
        }
    }

    
    boolean emailExists = true;
    while (emailExists) {
        System.out.print("Enter email: ");
        email = scanner.nextLine();
        emailExists = false;

        for (Admin existingAdmin : user.keySet()) {
            if (existingAdmin.getEmail().equals(email)) {
                emailExists = true;
                System.out.println("Email already exists. Please enter another email.");
                break;
            }
        }
    }

    
    Admin newAdmin = new Admin(username,fullName, phoneNumber, UserType.Admin, email);

    
    System.out.print("Enter password for the new admin: ");
    String password = scanner.nextLine();

    user.put(newAdmin, password);

    System.out.println("New admin added successfully.");
    return user;
     }
     
}




    

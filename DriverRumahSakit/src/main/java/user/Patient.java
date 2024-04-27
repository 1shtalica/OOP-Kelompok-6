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
public class Patient extends User {
   private String patientID;
   
    private PatientMcu[] mcu;
    private int i = 0;
   private String birtDate;
   private UserGender gender;
   private String address;
   private UserBloodType bloodType;
    public Patient(String name,String patientID,String username, String phoneNumber, UserType userType, String email,String birtDate, UserGender userGender, String address, UserBloodType bloodType) {
        super(username,name ,phoneNumber, userType, email);
        this.patientID = patientID;
        
        this.birtDate = birtDate;
        this.gender = userGender;
        this.address = address;
        this.bloodType = bloodType;
       
        
    }

    public String getPatientID() {
        return patientID;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public UserGender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public UserBloodType getBloodType() {
        return bloodType;
    }
    

    

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodType(UserBloodType bloodType) {
        this.bloodType = bloodType;
    }

    
    
    private String generatePatientId() {
        Random random = new Random();
        StringBuilder adminIDBuilder = new StringBuilder();

        
        for (int i = 0; i < 5; i++) {
            adminIDBuilder.append(random.nextInt(10)); 
        }

        return adminIDBuilder.toString();
    }

    public Patient login(Map<Patient, String> userCredentials) {
    Scanner scanner = new Scanner(System.in);
    
    
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    
    
    for (Map.Entry<Patient, String> entry : userCredentials.entrySet()) {
        Patient user = entry.getKey();
        String storedPassword = entry.getValue();
        
        
        if (user.getUsername().equals(username) && storedPassword.equals(password)) {
            
            System.out.println("Login successful!");
            return user;
        }
    }
    
    
    System.out.println("Login failed. Incorrect username or password.");
    return null;
}
    
    public Map<Patient, String> Register(Map<Patient, String> userCredentials){
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
         System.out.println("Registration Form");
        String username = "";
        String email= "";
        String phoneNumber="";
        int age ;
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
        
        System.out.print("Enter the patient's full name: ");
        String fullName = scanner.nextLine();
        
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
        
        
        
    System.out.println("Enter the patient's gender: ");
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
    
    System.out.print("Enter the patient's address: ");
    String patientAddress = scanner.nextLine();
    
    System.out.println("Enter the patient's gender: ");
    UserBloodType[] userBloodTypes = UserBloodType.values();
    for (int i = 0; i < userBloodTypes.length; i++) {
        System.out.println((i + 1) + ". " + userBloodTypes[i].name());
    }

   
    int userBloodTypeIndex = -1;
    boolean validUserBloodTypeIndex = false;
    while (!validUserBloodTypeIndex) {
        System.out.print("Enter the number corresponding to the gender type: ");
        userBloodTypeIndex = scanner.nextInt() - 1;

        
        if (userBloodTypeIndex >= 0 && userBloodTypeIndex < userBloodTypes.length) {
            validUserBloodTypeIndex = true;
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + userBloodTypes.length + ".");
        }
    }
    scanner.nextLine(); 

        UserBloodType userBloodType = userBloodTypes[userBloodTypeIndex];
    
        System.out.print("enter your password: ");
        password =  scanner.nextLine();
        
        
        Patient patient = new Patient(fullName,patientID,username,phoneNumber,UserType.Patient,email,birthDateString,userGender,patientAddress,userBloodType);
        userCredentials.put(patient, password);
        return userCredentials;
    }
    
    public void listofPatient(Map<Patient, String> userCredentials) {
    if (userCredentials.isEmpty()) {
        System.out.println("No patients have been registered yet.");
    } else {
        System.out.println("List of registered patients:");
        for (Patient patient : userCredentials.keySet()) {
            System.out.println("----------------------------");
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Full Name: " + patient.getName());
            System.out.println("Username: " + patient.getUsername());
            System.out.println("Email: " + patient.getEmail());
            System.out.println("Phone Number: " + patient.getPhoneNumber());
            System.out.println("Birth Date: " + patient.getBirtDate());
            System.out.println("Gender: " + patient.getGender().name());
            System.out.println("Address: " + patient.getAddress());
            System.out.println("Blood Type: " + patient.getBloodType().name());
            System.out.println("----------------------------");
        }
    }
}
    
    public String toString() {
        return "Data Diri:\n" +
                "Username: " + getUsername() + "\n" +
                "Nomor Telepon: " + getPhoneNumber() + "\n" +
                "Tipe Pengguna: " + getUserType() + "\n" +
                "Email: " + getEmail() + "\n" +
                "ID Pasien: " + patientID + "\n";
                
    }
    

    public void addMcu(String date, String disease, String result) {
        PatientMcu data = new PatientMcu(date, disease, result);
        this.mcu[this.i] = data;
        this.i++;
    }

    public void editMcu(int index, String date, String disease, String result) {
        if (index >= 0 && index < this.i) {
            this.mcu[index].setDate(date);
            this.mcu[index].setDisease(disease);
            this.mcu[index].setResult(result);
        } else {
            System.out.println("MCU not valid");
        }
    }
    
    

    public void updatePatientData(String name, String phoneNumber, String address, UserBloodType bloodType) {
    if (name != "") {
        this.setUsername(name);
    }
    if (phoneNumber != "") {
        this.setPhoneNumber(phoneNumber);
    }
    if (address != "") {
        this.setAddress(address);
    }
    if (bloodType != null) {
        this.setBloodType(bloodType);
    }
}
    
}

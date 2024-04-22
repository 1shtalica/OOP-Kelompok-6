/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Doctor extends User {

    private String doctorID;
    private String name;
    private DoctorType doctorType;
    private String birtDate;
    private UserGender gender;
    private String address;

    public Doctor(String doctorID, String name, DoctorType doctorType, String username, String phoneNumber, UserType userType, String email, String birthDate, UserGender gender, String address) {
        super(username, name, phoneNumber, userType, email);
        this.doctorID = doctorID;
        this.name = name;
        this.doctorType = doctorType;
        this.birtDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public DoctorType getDoctorType() {
        return doctorType;
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

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addMcu(Patient patient, String date, String disease, String result) {
        PatientMcu data = new PatientMcu(date, disease, result);
        patient.getMcu().add(data);
    }

    public void editMcu(Patient patient, int index, String date, String disease, String result) {
        List<PatientMcu> mcuList = patient.getMcu();
        if (index >= 0 && index < mcuList.size()) {
            PatientMcu mcuToUpdate = mcuList.get(index);

            mcuToUpdate.setDate(date);
            mcuToUpdate.setDisease(disease);
            mcuToUpdate.setResult(result);
            
            System.out.println("Success to edit");
        } else {
            System.out.println("Indeks not valid.");
        }
    }
    
    public void seeAllPatient(Map<Patient, String> patient) {
        for (Map.Entry<Patient, String> entry : patient.entrySet()) {
            Patient key = entry.getKey();
            System.out.println("id patient : " + key.getPatientID());
            System.out.println("name : " + key.getName());
            System.out.println("address : " + key.getAddress());
            System.out.println("birth : " + key.getBirtDate());
            System.out.println("phone number : " + key.getPhoneNumber());
            System.out.println("email : " + key.getEmail());
            System.out.println("blood type : " + key.getBloodType());
            System.out.println("gender : " + key.getGender());
        }
    }

    public Doctor login(Map<Doctor, String> userCredentials) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Map.Entry<Doctor, String> entry : userCredentials.entrySet()) {
            Doctor user = entry.getKey();
            String storedPassword = entry.getValue();

            if (user.getUsername().equals(username) && storedPassword.equals(password)) {

                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Login failed. Incorrect username or password.");
        return null;
    }
}

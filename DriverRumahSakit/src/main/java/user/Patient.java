/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author kevin
 */
public class Patient extends User {
   private String patientID;
   private int age;
    public Patient(int age ,String patientID,String username, String phoneNumber, UserType userType, String email) {
        super(username, phoneNumber, userType, email);
        this.patientID = patientID;
        this.age = age;
        
    }

    public String getPatientID() {
        return patientID;
    }

    public int getAge() {
        return age;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    public void updatePatient(String ID, int age, String username, String phone, UserType type, String email){
        setUsername(username);
        setPhoneNumber(phone);
        setUserType(type);
        setEmail(email);
        this.setPatientID(patientID);
        this.setAge(age);
    }
    
}

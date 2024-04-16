/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author kevin
 */
public class Doctor extends User{
    private String doctorID;
    private int age;
    private DoctorType doctorType;

    public Doctor(String doctorID, int age, DoctorType doctorType, String username, String phoneNumber, UserType userType, String email) {
        super(username, phoneNumber, userType, email);
        this.doctorID = doctorID;
        this.age = age;
        this.doctorType = doctorType;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public int getAge() {
        return age;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setAge(int age) {
        this.age = age;
    }

     public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }
    
        public void updateDoctorInfo(String doctorID, int age, DoctorType doctorType, String username, String phone, String email) {
        
        

        setDoctorID(doctorID);
        setAge(age);
        setDoctorType(doctorType);
        
        setUsername(username);
        setPhoneNumber(phone);
        setEmail(email);
        
        //bisa di log
    }
    
    
}

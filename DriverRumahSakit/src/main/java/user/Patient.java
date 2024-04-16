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
    private PatientMcu[] mcu;
    private int i = 0;

    public Patient(int age, String patientID, String username, String phoneNumber, UserType userType, String email) {
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

}

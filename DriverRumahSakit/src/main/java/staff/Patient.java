/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff;

/**
 *
 * @author adria
 */
public class Patient {
    private String name;
    private String address;
    private String contact;
    private String insurance;
    
    public Patient(String name, String address, String contact, String insurance) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.insurance = insurance;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getContact() {
        return this.contact;
    }
    
    public String getInsurance() {
        return this.insurance;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
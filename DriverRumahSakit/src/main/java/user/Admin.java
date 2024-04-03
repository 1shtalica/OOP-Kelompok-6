/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author kevin
 */
public class Admin extends User {
    private String adminID;

    public Admin(String adminID, String username, String phoneNumber, UserType userType, String email) {
        super(username, phoneNumber, userType,email);
        this.adminID = adminID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    
    public void updateAdminInfo(String adminID, String username, String phone, String email) {


        setAdminID(adminID);
        setUsername(username);
        setPhoneNumber(phone);
        setEmail(email);
        
        //bisa di log
    }
}

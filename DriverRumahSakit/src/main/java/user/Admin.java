/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.util.Random;

/**
 *
 * @author kevin
 */
public class Admin extends User {
    private String adminID;

    public Admin( String username, String phoneNumber, UserType userType, String email) {
        super(username, phoneNumber, userType,email);
        this.adminID = generateAdminID();
    }

    
     private String generateAdminID() {
        Random random = new Random();
        StringBuilder adminIDBuilder = new StringBuilder();

        // Menghasilkan lima angka acak
        for (int i = 0; i < 5; i++) {
            adminIDBuilder.append(random.nextInt(10)); // Menambahkan angka acak ke StringBuilder
        }

        return adminIDBuilder.toString(); // Mengembalikan ID admin dalam bentuk string
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

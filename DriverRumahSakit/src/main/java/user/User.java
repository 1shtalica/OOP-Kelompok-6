/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author kevin
 */
public abstract class User {
    
    private String username;
    private String name;
    private String phoneNumber;
    private String email;
    private UserType userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   

    public User(String username,String name, String phoneNumber, UserType userType, String email) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

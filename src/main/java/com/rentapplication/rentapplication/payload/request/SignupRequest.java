package com.rentapplication.rentapplication.payload.request;

import java.sql.Date;
import java.util.Set;


public class SignupRequest {

    private String username;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userImage;
    private String userPhone;
    private Date userBirthdate;
    private String userFunctionality;

    public void setUserFunctionality(String userFunctionality) {
        this.userFunctionality = userFunctionality;
    }

    private String userCity;

    public String getUserFunctionality() {
        return userFunctionality;
    }



    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }





    private Set<String> role;


    public String getUserFirstname() {
        return userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public Date getUserBirthdate() {
        return userBirthdate;
    }

    private String password;
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserBirthdate(Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
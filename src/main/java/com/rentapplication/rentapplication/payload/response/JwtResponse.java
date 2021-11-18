package com.rentapplication.rentapplication.payload.response;

import com.rentapplication.rentapplication.entities.City;
import com.rentapplication.rentapplication.entities.Functionality;

import java.sql.Date;
import java.util.List;

public class JwtResponse {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String image;
    private String phone;
    private Date birthdate;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Date createdAt;


    private City city;
    private Functionality functionality;
    private List<String> roles;
    private String token;
    private String type = "Bearer";

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setFunctionality(Functionality functionality) {
        this.functionality = functionality;
    }



    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public City getCity() {
        return city;
    }

    public Functionality getFunctionality() {
        return functionality;
    }







    public JwtResponse(String accessToken, int id, String username, String firstname, String lastname, String email
            , String address, String image, String phone, Date birthdate, Date createdAt, City city, Functionality functionality
            , List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.image = image;
        this.phone = phone;
        this.birthdate = birthdate;
        this.createdAt = createdAt;
        this.city = city;
        this.functionality = functionality;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String firstname) {
        this.lastname = lastname;
    }

    public List<String> getRoles() {
        return roles;
    }
}

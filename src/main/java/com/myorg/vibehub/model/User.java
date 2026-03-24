package com.myorg.vibehub.model;

import com.myorg.vibehub.enums.gender;

public class User {

//    Not using lombok For educational purposes because Lombok makes setter getter invensible

    private Long id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public gender getGender() {
        return gender;
    }

    public void setGender(gender gender) {
        this.gender = gender;
    }
}

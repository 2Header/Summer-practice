package com.example.ver_3;

import java.util.jar.Attributes;

public class User {
    public String firstName;
    public String secondName;
    public String password;
    public String email;
    public String phoneNumber;

    public User() {

    }

    public User(String firstName, String secondName, String password, String email, String phonenumber){

        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phonenumber;
    }
}

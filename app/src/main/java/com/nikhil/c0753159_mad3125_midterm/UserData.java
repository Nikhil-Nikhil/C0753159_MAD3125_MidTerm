package com.nikhil.c0753159_mad3125_midterm;

public class UserData {
    String email;
    String Password;

    public UserData(String email, String password) {
        this.email = email;
        Password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

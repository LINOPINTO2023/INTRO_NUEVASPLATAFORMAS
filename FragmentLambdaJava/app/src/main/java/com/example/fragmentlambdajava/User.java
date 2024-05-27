package com.example.fragmentlambdajava;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String username;
    private String password;

    public User(String firstname, String lastname, String email, String phone, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

package com.spring.model;

public class AppUser {
    private String userName;
    private String password;
    private String roles;

    public AppUser(String userName, String password, String roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public AppUser() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }
}

package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String username;

    private boolean isAdmin;
    private String email;
    private String password;

    public User(boolean isAdmin, String email, String username, String password) {
        this.isAdmin = isAdmin;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
        this.isAdmin = false;
        this.email = "";
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

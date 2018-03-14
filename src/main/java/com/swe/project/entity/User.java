package com.swe.project.entity;

import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;

    public static enum userType {
        admin , customer , storeOwner;
    }
    private userType type;
    private String email;
    private String password;

    public User(userType type, String email, String username, String password) {
        this.type = type;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
        this.type = userType.customer;
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

    public void setAdmin(userType type) {
        this.type = type;
    }

    public userType getType() {
        return type;
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

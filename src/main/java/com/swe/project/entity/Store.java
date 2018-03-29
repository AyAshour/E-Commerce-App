package com.swe.project.entity;

import javax.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String type;
    private String location;
    private String owner_username;
    private boolean accepted;

    public Store(String name, String type, String location, String ownerUsername) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.owner_username = ownerUsername;
        this.accepted = false;
    }

    public Store() {
        id = 0;
        this.name = "";
        this.type = "";
        this.location = "";
        this.owner_username = "";
        this.accepted = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerUsername() {
        return owner_username;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.owner_username = ownerUsername;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}

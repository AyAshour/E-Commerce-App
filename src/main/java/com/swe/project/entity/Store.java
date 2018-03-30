package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@EnableAutoConfiguration
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public String name;
    public String type;
    public String location;
    public boolean accepted;

    @ManyToOne
    @JoinColumn
    public User owner;




    public Store(String name, String type, String location, String ownerUsername) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.owner = new User(ownerUsername);
        this.accepted = false;
    }
    public Store(int id){
        this.id = id;
        this.name = "";
        this.type = "";
        this.location = "";
        this.accepted = false;
    }
    public Store() {
        id = 0;
        this.name = "";
        this.type = "";
        this.location = "";
        this.accepted = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}

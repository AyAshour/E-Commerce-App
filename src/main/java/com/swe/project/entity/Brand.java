package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;
    @OneToOne
    @JoinColumn(name = "categoryId")
    public Category category;
    public String name;

    @OneToMany
    public List<Product> products;

    public Brand(){
        name="";
    }

    public Brand(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


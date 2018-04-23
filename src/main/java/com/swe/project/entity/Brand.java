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
    private Integer brandId;
    public String name,category;

    @OneToMany
    public List<Product> products;

    public Brand(){
        name="";
    }

    public Brand(String name){
        this.name = name;
    }

    public int getId() {
        return brandId;
    }

    public void setId(int id) {
        this.brandId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


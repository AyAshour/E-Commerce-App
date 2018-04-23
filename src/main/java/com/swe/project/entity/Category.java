package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
public class Category {
    ///@GeneratedValue(strategy = GenerationType.AUTO)
   /// private Integer id  = 0;
    @Id
    public String name;

    public Category() {
        name = "";
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@EnableAutoConfiguration
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name,category;

    @OneToMany
    public ArrayList<Product> products;
    public Brand(){
        id=0;
        name="";
        category="";
    }
    public Brand(int id,String name,String category){
        this.id= id;
        this.name = name;
        this.category= category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@EnableAutoConfiguration
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public String name;
    public double price;
    public String category;
    public boolean inStock;

    @ManyToOne
    @JoinColumn
    public Brand brand;

    @ManyToMany
    public ArrayList<User> viewers;

    @OneToMany
    public User buyer;

    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0.0;
        this.category = "";
    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = true;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}


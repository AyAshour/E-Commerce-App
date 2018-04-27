package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    public String name;
    public double price;
    public double low_range;
    public double high_range;
    public boolean inStock;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "brandId")
    public Brand brand;

   /* @ManyToMany
    public List<User> viewers = null;*/

    @OneToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
        this.name = "";
        this.low_range = this.high_range = 0;
        this.price = 0.0;
        this.quantity = 0;
        this.brand = null;
        this.category = null;
    }

    public Product(String name, double low ,double high, double price, Category category, Integer quantity, Brand brand) {

        this.name = name;
        this.low_range = low;
        this.high_range = high;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
        this.inStock = true;
    }

    public Integer getId() {
        return this.productId;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.productId = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}


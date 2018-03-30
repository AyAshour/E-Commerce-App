package com.swe.project.entity;


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
    private Integer id;

    private String name;
    private String priceRange;
    private double price;
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    private boolean inStock;


    public Product() {
        this.name = "";
        this.priceRange = "";
        this.price = 0.0;
        this.quantity = 0;
        this.brand = null;
        this.category = null;
    }

    public Product(String name, String priceRange, double price, Integer quantity, Brand brand, Category category) {
        this.name = name;
        this.priceRange = priceRange;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrandId() {
        return brand;
    }

    public void setBrandId(Brand brand) {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}


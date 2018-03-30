package com.swe.project.entity;

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
    private String category;
    private Integer brandId;
    private boolean inStock;


    public Product() {
        this.id = 0;
        this.name = "";
        this.priceRange = "";
        this.price = 0.0;
        this.category = "";
    }

    public Product(String name, String priceRange, double price, String category) {
        this.name = name;
        this.priceRange = priceRange;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
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

    public void setCategory(String category) {
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}


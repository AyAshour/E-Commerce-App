package com.swe.project.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SystemProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;

    public String name;
    public double low_range;
    public double high_range;
    public String category;
    private Boolean valid;

    public SystemProduct(String name, double low_range, double high_range, String category){
        this.name = name;
        this.low_range = low_range;
        this.high_range = high_range;
        this.category = category;
        this.valid = false;
    }

    public Boolean isValid() {
        return valid;
    }
    public void makeValid() {
        this.valid = true;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

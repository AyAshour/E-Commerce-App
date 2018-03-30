package com.swe.project.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AcceptedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public String name;
    public double low_range;
    public double high_range;
    public String category;

    public AcceptedProducts(String name,double low_range,double high_range,String category){
        this.name = name;
        this.low_range = low_range;
        this.high_range = high_range;
        this.category = category;
    }
}

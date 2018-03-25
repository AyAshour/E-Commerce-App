package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public Integer productID;
    public String username;
}

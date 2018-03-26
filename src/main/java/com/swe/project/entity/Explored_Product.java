package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Explored_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer ID;

    private Integer productID;
    private String username;

    Explored_Product() {
        ID=0;
        productID=0;
        username="";
    }
    Explored_Product(Integer ID, Integer productID, String username){
        this.ID = ID;
        this.productID = productID;
        this.username  = username;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

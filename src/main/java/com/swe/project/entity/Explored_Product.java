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
    private Integer customerID;

    Explored_Product() {
        ID=0;
        productID=0;
        customerID=0;
    }
    Explored_Product(Integer ID, Integer productID, Integer customerID){
        this.ID = ID;
        this.productID = productID;
        this.customerID = customerID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}

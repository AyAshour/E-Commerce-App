package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductActions extends Action{

    @ManyToOne
    @JoinColumn(name = "Product")
    Product product;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductActions(Product product) {
        this.product = product;
    }
}

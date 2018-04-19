package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductActions extends Action{
    private static final String AFFECTED_OBJECT = "product";

    @ManyToOne
    @JoinColumn(name = "Product")
    Product product;

    public ProductActions() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductActions(Product product) {
        this.product = product;
        this.affectedObject = AFFECTED_OBJECT;
    }
}

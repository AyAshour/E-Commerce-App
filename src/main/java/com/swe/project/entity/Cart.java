package com.swe.project.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;

    @OneToOne
    @JoinColumn(name = "userId")
    User user;

    @OneToMany(targetEntity = Product.class)
    Map<Integer,Product> products;



    public Cart() {
        this.user = null;
        this.products = null;
    }

    public Cart(User user, Map<Integer, Product> products) {
        this.user = user;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProduct(Map<Integer, Product> products) {
        this.products = products;
    }
}

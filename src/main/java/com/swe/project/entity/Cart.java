package com.swe.project.entity;

import javax.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "userId")
    User user;

    @OneToMany(targetEntity = Product.class)
    List<Product> products;

    public Cart() {
        this.user = null;
        this.products = null;
    }

    public Cart(User user, List<Product> products) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

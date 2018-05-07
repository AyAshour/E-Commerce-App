package com.swe.project.entity;

import com.swe.project.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import java.util.Set;


@Entity
@EnableAutoConfiguration
public class User {

    @Id
    public String username;

    public String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="user_types",
            joinColumns=@JoinColumn(name="username", referencedColumnName="username"),
            inverseJoinColumns=@JoinColumn(name="userTypeId", referencedColumnName="userTypeId"))
    private Set<UserType> userRoles;

    @ManyToMany
    private Set<Product> buyProducts;

    @ManyToMany
    private Set<Product> viewedProducts;

    @OneToMany
    private Set<Store> stores;

    public User(String email, String username, String password, Set<UserType> userRoles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
        this.cart = null;
    }

    public User() {
        this.email = "";
        this.username = "";
        this.password = "";
    }

    public User(String ownerUsername , UserType type) {
        this.username = ownerUsername;
        userRoles = new HashSet<>();
        userRoles.add(type);
        this.email = "";
        this.password = "";
        cart = new Cart(this,null);
    }


    public Set<UserType> getUserRoles() {
        if(this.userRoles == null) {
            this.userRoles = new HashSet<UserType>();
        }
        return userRoles;
    }


    public void setUserRoles(Set<UserType> userRoles) {
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Product> getViewedProducts() {
        if(this.viewedProducts == null) {
            this.viewedProducts = new HashSet<Product>();
        }
        return viewedProducts;
    }

    public void setViewedProducts(Set<Product> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }

    public void addViewedProduct(Product p) {
        if(this.viewedProducts == null) {
            this.viewedProducts = new HashSet<Product>();
        }
        this.viewedProducts.add(p);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        if(this.cart == null) {
            this.cart = new Cart();
        }
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    private void inintStores() {
        if(this.stores == null) {
            this.stores = new HashSet<Store>();
        }
    }
    public void addStores(Set<Store> stores) {
        inintStores();
        this.stores.addAll(stores);
    }

    public void addStore(Store store) {
        inintStores();
        this.stores.add(store);
    }

    public  Set<Store> getStores() {
        inintStores();
        return this.stores;
    }
}

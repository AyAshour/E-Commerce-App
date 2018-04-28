package com.swe.project.entity;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_types",
            joinColumns=@JoinColumn(name="username", referencedColumnName="username"),
            inverseJoinColumns=@JoinColumn(name="userType", referencedColumnName="userType"))
    private Set<UserType> userTypes;

    public User(String email, String username, String password, Set<UserType> userTypes) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userTypes = userTypes;
        this.cart = null;
    }

    public User() {
        this.email = "";
        this.username = "";
        this.password = "";
        this.userTypes = new HashSet<>();
        this.cart = null;
    }

   /* @OneToMany
    public Set<Product> buyProducts;


    public Set<User> collaborators;
*/



    /*
    @ManyToMany
    public Set<Product> viewedProducts;*/




   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private List<UserType> userRoles;
=======

    public User(String ownerUsername) {
        this.username = ownerUsername;
        this.type = userType.customer.getType();
        this.email = "";
        this.username = "";
        this.password = "";
    }

    public static enum userType {
        admin("admin"), customer("customer"), storeOwner("owner");
        public String type;

        userType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static userType parse(String type) {
            for (userType type1 : userType.values()) {
                if (type1.type == type) {
                    return type1;
                }
            }
            return null;
        }
    }


    public List<UserType> getUserRoles() {
        return userRoles;
    }


    public void setUserRoles(List<UserType> userRoles) {
        this.userRoles = userRoles;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserType> getUserTypes() {
        return this.userTypes;
    }

    public void setUserTypes(Set<UserType> userTypes) {
        this.userTypes = userTypes;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /*public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }*/
/*
    public Set<Product> getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(Set<Product> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }
*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

/*
    public void addStores(Set<Store> stores) {
        this.stores.addAll(stores);
    }
    public void addCollaborators(Set<User> Collaborators) {
        this.collaborators(Collaborators);
    }

    private void collaborators(Set<User> collaborators) {
    }
*/
}

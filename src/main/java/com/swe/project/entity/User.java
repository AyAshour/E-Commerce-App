package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;


@Entity
@EnableAutoConfiguration
public class User {

    @Id
    public String username;
    public String type;
    public String email;
    private String password;


    @OneToMany
    public Set<Product> buyProducts;

    @OneToMany
    public Set<User> collaborators;

    @OneToMany
    public Set<Store> stores;

    @ManyToMany
    public Set<Product> viewedProducts;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


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


    public User(userType type, String email, String username, String password) {
        this.type = type.getType();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String owner, String email, String username, String password) {
        this.type = userType.customer.getType();
        this.email = "";
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Product> getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(Set<Product> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }

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

    public void addStores(Set<Store> stores) {
        this.stores.addAll(stores);
    }
    public void addCollaborators(Set<User> Collaborators) {
        this.collaborators(Collaborators);
    }

    private void collaborators(Set<User> collaborators) {
    }
}

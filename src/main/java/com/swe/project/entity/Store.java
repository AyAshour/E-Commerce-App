package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@EnableAutoConfiguration
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storeId;

    public String name;
    public String type;
    public String location;
    public boolean accepted;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="store_products",
            joinColumns=@JoinColumn(name="storeId", referencedColumnName="storeId"),
            inverseJoinColumns=@JoinColumn(name="productId", referencedColumnName="productId"))
    private List<Product> products;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="store_collaborators",
            joinColumns=@JoinColumn(name="storeId", referencedColumnName="storeId"),
            inverseJoinColumns=@JoinColumn(name="username", referencedColumnName="username"))
    private Set<User> collaborators;


    public Store(String name, String type, String location, User owner) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.owner = owner;
        this.accepted = false;
        this.products = new ArrayList<Product>();
    }
    public Store(){
        this.name = "";
        this.type = "";
        this.location = "";
        this.owner = null;
        this.accepted = false;
        this.products = new ArrayList<Product>();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

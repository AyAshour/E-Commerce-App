package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
@EnableAutoConfiguration
public class User {

    @Id
    public String username;

    public String type;
    public String email;
    private String password;

    /*@OneToMany
    public Set<Store> stores;

    @ManyToMany
    public Set<Product> viewedProducts;
*/
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private List<UserType> userRoles;

    public List<UserType> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserType> userRoles) {
        this.userRoles = userRoles;
    }*/

    public User(UserType type, String email, String username, String password, List<UserType> userTypeset) {
       // this.type = type.getType();
        this.email = email;
        this.username = username;
        this.password = password;
       // userRoles = userTypeset;
    }

    public User() {
      //  this.type = UserType.customer.getType();
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

}

package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import javax.persistence.*;


@Entity
@EnableAutoConfiguration
public class User {

    @Id
    private String username;


    public static enum userType {
            admin("admin") , customer("customer") , storeOwner("owner");
        public String type;
        userType(String type) {
            this.type=type;
        }
        public String getType(){
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static userType parse(String type){
            for(userType type1 :userType.values()){
                if(type1.type==type){
                    return type1;
                }
            }
            return null;
        }
    }



    private String type;

    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    public User(userType type, String email, String username, String password) {
        this.type = type.getType();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
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

    public void setType(userType type) {
        this.type= type.getType();
    }

    public userType getType() {
        return userType.parse(type);
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

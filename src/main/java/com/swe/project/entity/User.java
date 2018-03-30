package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@EnableAutoConfiguration
public class User {

    @Id
    public String username;
    public String type;
    public String email;
    private String password;

    @OneToMany
    public ArrayList<Store> stores;

    @ManyToMany
    public ArrayList<Product> viewedProducts;

    public User(String ownerUsername) {
        this.username=ownerUsername;
        this.type = userType.customer.getType();
        this.email = "";
        this.username = "";
        this.password = "";
    }


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



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

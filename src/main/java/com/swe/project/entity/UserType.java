package com.swe.project.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userTypeId;

    @Column(name = "userType")
    @Enumerated(EnumType.ORDINAL)
    private Type userType;

    public UserType(Type userType) {
        this.userType = userType;
    }

    public UserType() {
        this.userType = Type.customer;
    }

    public Type getUserType() {
        return userType;
    }

    public void setUserType(Type userType) {
        this.userType = userType;
    }

    public static enum Type{
        admin("admin") , customer("customer") , storeOwner("owner"), collaborator("collaborator");

        public String type;

        Type(String type) {
            this.type=type;
        }
        public String getType(){
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static Type parse(String type){
            for(Type type1 :Type.values()){
                if(type1.type==type){
                    return type1;
                }
            }
            return null;
        }

    }
}

package com.swe.project.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class  Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected String affectedObject;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private  Store store;

    @ManyToOne
    @JoinColumn(name = "User")
    private User OriginalStoreOwner;

    public String type;

    //List<Action>
    public static enum ActionType {
        insert, update, delete;
    }

        @Contract(pure = true)
        public String getType(){
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public User getOriginalStoreOwner() {
        return OriginalStoreOwner;
    }

    public void setOriginalStoreOwner(User originalStoreOwner) {
        OriginalStoreOwner = originalStoreOwner;
    }

    public String getAffectedObject() {
        return affectedObject;
    }

    public void setAffectedObject(String affectedObject) {
        this.affectedObject = affectedObject;
    }
}

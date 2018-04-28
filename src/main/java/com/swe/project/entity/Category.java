package com.swe.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    public String name;

/*    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    public List<Product> products;*/

    public Category(){
        name = "";
    }

    public Category(String name){
        this.name = name;
    }

    public int getId() {
        return categoryId;
    }

    public void setId(int id) {
        this.categoryId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.swe.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoreProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer ID;
    public Integer storeID;
    public Integer product_id;

}

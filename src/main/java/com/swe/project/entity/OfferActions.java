package com.swe.project.entity;

import javax.persistence.Entity;

@Entity
public class OfferActions extends Action{

    double offer;

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }
}

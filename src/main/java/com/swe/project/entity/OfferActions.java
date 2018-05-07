package com.swe.project.entity;

import javax.persistence.Entity;

@Entity
public class OfferActions extends Action{
    private static final String AFFECTED_OBJECT = "offer";



    double offer;

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
        this.affectedObject = AFFECTED_OBJECT;
    }
}

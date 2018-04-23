package com.swe.project.discounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AdminDiscount implements Discount{
    private static final String ADMIN_ID = "admin";
    private static final double VALUE = 0.2;


    @Autowired
    private DiscountFactory discountFactory;

    @PostConstruct
    public void selfRegister() {
        discountFactory.addDiscount(ADMIN_ID, this);
    }
    @Override
    public double applyDiscount(double price) {
        return price - (price*VALUE);
    }

}

package com.swe.project.discounts;

import javax.annotation.PostConstruct;

public class AdminDiscount implements Discount{

    private static final String ADMIN_ID = "admin";
    private static final double VALUE = 0.2;

    private DiscountFactory discountFactory;

    @Override
    @PostConstruct
    public void selfRegister() {
        discountFactory.addDiscount(ADMIN_ID, this);
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price*VALUE);
    }

}

package com.swe.project.discounts;

import javax.annotation.PostConstruct;

public class CustomerDiscount implements Discount{

    private static final String CUSTOMER_ID = "customer";
    private static final double VALUE = 0.1;
    private DiscountFactory discountFactory;

    @Override
    public double applyDiscount(double price) {
        return price - (price*VALUE);
    }

    @Override
    @PostConstruct
    public void selfRegister() {
        discountFactory.addDiscount(CUSTOMER_ID, this);
    }
}

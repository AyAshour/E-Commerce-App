package com.swe.project.discounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class CustomerDiscount implements Discount{

    private static final String CUSTOMER_ID = "customer";
    private static final double VALUE = 0.1;

    @Override
    public double applyDiscount(double price) {
        return price - (price*VALUE);
    }

    @Autowired
    private DiscountFactory discountFactory;

    @PostConstruct
    public void selfRegister() {
        discountFactory.addDiscount(CUSTOMER_ID, this);
    }
}

package com.swe.project.discounts;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DiscountFactory  {
    private Map<String, Discount> discountFactory;

    public void addDiscount(String key, Discount discount){
        discountFactory.put(key, discount);
    }
    public Discount getDiscount(String key){
        return discountFactory.get(key);
    }
}

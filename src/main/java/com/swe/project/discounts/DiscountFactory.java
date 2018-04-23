package com.swe.project.discounts;

import com.swe.project.actions.ActionHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DiscountFactory  {
    private Map<String, Discount> discountFactoryMap;

    public void addDiscount(String key, Discount discount){
        discountFactoryMap.put(key, discount);
    }
    public Discount getDiscount(String key){
        return discountFactoryMap.get(key);
    }


    public DiscountFactory() {
        discountFactoryMap = new HashMap<>();
    }

}

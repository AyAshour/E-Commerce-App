package com.swe.project.service;

import org.springframework.stereotype.Service;
@Service
public class ShippingService {

    public boolean canBeShipped(String address){
        return true; //shipping possibility according to shipping company
    }
}

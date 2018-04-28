package com.swe.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Service
public class ShippingService {

    public boolean canBeShipped(String address){
        return true; //shipping possibility according to shipping company
    }
}

package com.swe.project.service;

import com.swe.project.entity.Product;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class BuyProductService {


    @Autowired
    ProductRepository productRepo;

    public double buyProduct(Product product, Integer quantity)
    {

        double price = 0.0;
        if(product.getQuantity() >= quantity){
            price = quantity * product.getPrice();

            Integer oldQuantity = product.getQuantity();
            product.setQuantity(oldQuantity - quantity);
            productRepo.save(product);
        }
        return price;
    }
}

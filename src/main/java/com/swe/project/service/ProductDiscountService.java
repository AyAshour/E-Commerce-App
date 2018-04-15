package com.swe.project.service;

import com.swe.project.entity.Product;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDiscountService {

    @Autowired
    ProductRepository productRepo;
    public void ApplyDiscount(Product product, double discount)
    {

        product.setPrice(discount * product.getPrice());
        productRepo.save(product);
    }

}

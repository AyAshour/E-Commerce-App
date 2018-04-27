package com.swe.project.service;

import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public Product getProductById(Integer productId){
        return productRepo.findProductByProductId(productId);
    }

    public Iterable<Product> getAll(){
        return productRepo.findAll();
    }

    public void removeProduct(Integer productId){
        productRepo.deleteById(productId);
    }

    public Iterable<Product> getProductsOutOfStock() {
        return productRepo.findAllByInStock(false);
    }


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
    public void ApplyDiscount(Product product, double discount)
    {

        product.setPrice(discount * product.getPrice());
        productRepo.save(product);
    }
}

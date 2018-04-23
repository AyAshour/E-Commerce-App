package com.swe.project.service;

import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    StoreRepository storeRepo;
    ProductRepository productRepo;
    public Store addProduct(Product product, Integer storeId){
        Store store = storeRepo.findStoreById(storeId);

        Product existProduct = productRepo.findProductById(product.getId());
        if(existProduct == null)
            return null;

        List<Product> products =  store.getProducts();
        products.add(product);
        store.setProducts(products);
        storeRepo.save(store);

        Integer addedQuantity = product.getQuantity();

        Integer existQuantity = existProduct.getQuantity();
        existProduct.setQuantity(existQuantity + addedQuantity);
        productRepo.save(existProduct);

        return store;
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
    public void remove( Product product, Store store){

        //Store store = storeRepo.findStoreById(storeId);
        Product productInSystem = productRepo.findProductById(product.getId());
        List<Product> storeProducts =   store.getProducts();
        for(Product p : storeProducts){
            if(p.equals(product)){

                storeProducts.remove(p);
                store.setProducts(storeProducts);

                storeRepo.save(store);

                productInSystem.setQuantity(productInSystem.getQuantity() - p.getQuantity());
                productRepo.save(productInSystem);

                return;
            }
        }
    }
}

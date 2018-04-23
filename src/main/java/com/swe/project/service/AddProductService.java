package com.swe.project.service;

import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {
    StoreRepository storeRepo;
    ProductRepository productRepo;
    public Store addProduct(Product product, Integer storeId){
        Store store = storeRepo.findStoreById(storeId);

        store.getProducts().add(product);
        storeRepo.save(store);

        Integer addedQuantity = product.getQuantity();
        Product existProduct = productRepo.findProductById(product.getId());
        Integer existQuantity = existProduct.getQuantity();
        existProduct.setQuantity(existQuantity + addedQuantity);
        productRepo.save(existProduct);

        return store;
    }

}

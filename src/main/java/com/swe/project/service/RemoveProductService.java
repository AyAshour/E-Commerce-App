package com.swe.project.service;

import com.swe.project.entity.*;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class RemoveProductService {
    @Autowired
    StoreRepository storeRepo;

    @Autowired
    ProductRepository productRepo;

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

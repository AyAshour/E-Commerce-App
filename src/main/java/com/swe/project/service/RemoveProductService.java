package com.swe.project.service;

import com.swe.project.entity.*;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RemoveProductService {
    @Autowired
    StoreRepository storeRepo;

    @Autowired
    ProductRepository productRepo;

    public void remove( Product product, Integer storeId, User originalOwner){
        Store store = storeRepo.findStoreById(storeId);
        Product productinSystem = productRepo.findProductById(product.getId());
        if(originalOwner.equals(store.getOwner())){
            for(Product p : store.getProducts()){
                if(p.equals(product)){

                    store.getProducts().remove(p);
                    storeRepo.save(store);

                    productinSystem.setQuantity(productinSystem.getQuantity() - p.getQuantity());
                    productRepo.save(productinSystem);

                    Action action = new ProductActions(product);
                    action.setStore(store);
                    action.setType("delete");
                    //ActionController actionController = new ProductActionsController();
                    // actionController.remove(action);
                }
            }
        }
    }
}

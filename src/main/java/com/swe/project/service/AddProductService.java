package com.swe.project.service;

import com.swe.project.actions.ActionHandler;
import com.swe.project.actions.ActionHandlerFactory;
import com.swe.project.entity.Action;
import com.swe.project.entity.Product;
import com.swe.project.entity.ProductActions;
import com.swe.project.entity.Store;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {
    StoreRepository storeRepo;
    ProductRepository productRepo;
    ActionHandlerFactory actionHandlerFactory;
    ActionHandler actionHandler;
    public void addProduct(Product product, Integer storeId){
        Store store = storeRepo.findStoreById(storeId);

        store.getProducts().add(product);
        storeRepo.save(store);

        Integer addedQuantity = product.getQuantity();
        Product existProduct = productRepo.findProductById(product.getId());
        Integer existQuantity = existProduct.getQuantity();
        existProduct.setQuantity(existQuantity + addedQuantity);
        productRepo.save(existProduct);

        Action action = new ProductActions(product);
         action.setStore(store);
        action.setType("insert");

        actionHandler = actionHandlerFactory.getHandler("product");
        actionHandler.doAction(action );
    }

}

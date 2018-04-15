package com.swe.project.repository;

import com.swe.project.entity.Product;
import com.swe.project.entity.ProductActions;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;

public interface ProductActionsRepository extends CrudRepository<ProductActions, Integer>{
    Iterable<ProductActions> findAllByStoreId (Integer storeId);
   // Iterable<ProductActions> findAllByStoreIdAndProduct (Integer storeId, Product product);

}

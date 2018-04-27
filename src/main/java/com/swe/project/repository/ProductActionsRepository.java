package com.swe.project.repository;

import com.swe.project.entity.Product;
import com.swe.project.entity.ProductActions;
import com.swe.project.entity.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
@Repository
public interface ProductActionsRepository extends CrudRepository<ProductActions, Integer>{
    Iterable<ProductActions> findAllByStore (Store store);
   // Iterable<ProductActions> findAllByStoreIdAndProduct (Integer storeId, Product product);

}

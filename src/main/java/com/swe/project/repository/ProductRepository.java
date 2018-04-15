package com.swe.project.repository;

import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findAllByInStock(boolean inStock);
    Iterable<Product> findAllByStore(Store s);

    Product findProductById(Integer id);
}
package com.swe.project.repository;

import com.swe.project.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findProductById(Integer id);
    Iterable<Product> findAllByInStock(boolean inStock);

}
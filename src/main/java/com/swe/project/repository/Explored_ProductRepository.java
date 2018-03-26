package com.swe.project.repository;

import com.swe.project.entity.Explored_Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Explored_ProductRepository extends CrudRepository<Explored_Product, Integer> {
    Iterable<Explored_Product> findAll();

    Iterable<Explored_Product> findAllByProductID(Integer id);
}

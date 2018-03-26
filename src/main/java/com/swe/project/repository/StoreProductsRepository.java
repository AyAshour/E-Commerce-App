package com.swe.project.repository;

import com.swe.project.entity.StoreProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreProductsRepository extends CrudRepository<StoreProducts,Integer> {



    Iterable<StoreProducts> findAllByStoreID(Integer storeID);
}

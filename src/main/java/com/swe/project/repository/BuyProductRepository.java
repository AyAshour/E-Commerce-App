package com.swe.project.repository;

import com.swe.project.entity.BuyProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyProductRepository extends CrudRepository<BuyProduct,Integer>{

}

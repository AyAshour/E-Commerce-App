package com.swe.project.repository;

import com.swe.project.entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<Store, Integer> {
    List<Store> findStoresByAccepted(boolean accepted);
    Store findStoreById(Integer id);
    Integer removeStoreById(Integer id);
}

package com.swe.project.repository;

import com.swe.project.entity.OfferActions;
import org.springframework.data.repository.CrudRepository;

public interface OfferActionsRepository extends CrudRepository<OfferActions, Integer> {
  //  Iterable<OfferActions> findAllByStoreId (Integer storeId);
}

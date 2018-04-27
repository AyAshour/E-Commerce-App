package com.swe.project.repository;

import com.swe.project.entity.OfferActions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferActionsRepository extends CrudRepository<OfferActions, Integer> {
  //  Iterable<OfferActions> findAllByStore (Store store);
}

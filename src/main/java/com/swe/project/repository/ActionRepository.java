package com.swe.project.repository;

import com.swe.project.entity.Action;
import com.swe.project.entity.OfferActions;
import com.swe.project.entity.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActionRepository extends CrudRepository<Action, Integer> {
    List<Action> findAllByStore(Store store); //all commands on the system (for admin)
    Action findActionByActionId (Integer actionId);


}

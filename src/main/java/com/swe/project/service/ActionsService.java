package com.swe.project.service;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.entity.Store;
import com.swe.project.repository.ActionRepository;
import com.swe.project.repository.ProductActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class ActionsService {

    @Autowired
    ActionRepository actionRepository;

     @Autowired
     StoreService storeService;

    public void addAction(ProductActions productActions){
        actionRepository.save((Action)productActions);
    }

    public void removeAction(ProductActions action){
        actionRepository.delete(action);
    }

    public List<Action> showActions(Integer storeId){
        Store store = storeService.getStoreById(storeId);
        List<Action> actions = actionRepository.findAllByStore(store);
        return actions;
    }

    public void saveAction(Action action){
        actionRepository.save(action);
    }

    public Action getActionById(Integer actionId) {
        return actionRepository.findActionByActionId(actionId);
    }
}

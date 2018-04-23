package com.swe.project.service;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.repository.ActionRepository;
import com.swe.project.repository.ProductActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionsService {

    @Autowired
    ActionRepository actionRepository;

    public void addAction(ProductActions productActions){
        actionRepository.save((Action)productActions);
    }
    public void removeAction(ProductActions action){
        actionRepository.delete(action);
    }
    public Iterable<Action> showActions(Integer storeId){
        Iterable<Action> actions = actionRepository.findAllById(storeId);
        return actions;
    }

    public void saveAction(Action action){
        actionRepository.save(action);
    }

    public Action getActionById(Integer actionId) {
        return actionRepository.findActionById(actionId);
    }
}

package com.swe.project.service;

import com.swe.project.entity.Action;
import com.swe.project.entity.User;
import com.swe.project.repository.ActionRepository;
import com.swe.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowActionsService {

    //authority goes to original store owner
    @Autowired
    ActionRepository actionRepo;
    public Iterable<Action> showActions(Integer storeId){
        Iterable<Action> actions = actionRepo.findAllById(storeId);
        return actions;
    }
}

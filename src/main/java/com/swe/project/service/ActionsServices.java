package com.swe.project.service;

import com.swe.project.entity.Action;
import com.swe.project.entity.ProductActions;
import com.swe.project.repository.ActionRepository;
import com.swe.project.repository.ProductActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductActionsService {
    @Autowired
    ProductActionsRepository productActionsRepo ;
    @Autowired
    ActionRepository actionRepository;

    public void addAction(ProductActions productActions){
        productActionsRepo.save(productActions);
        actionRepository.save((Action)productActions);
    }
    public void removeAction(ProductActions action){
        productActionsRepo.delete(action);
        actionRepository.delete(action);
    }
}

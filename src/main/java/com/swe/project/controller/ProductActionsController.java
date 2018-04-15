package com.swe.project.controller;

import com.swe.project.entity.Action;
import com.swe.project.service.InsertProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ProductActionsController extends ActionController {
    @Autowired
    InsertProductService insertProductService ;
    @Override
    ResponseEntity<?> Add(Action action) {
        insertProductService.add(action);
        return  ResponseEntity.ok().build();
    }
}

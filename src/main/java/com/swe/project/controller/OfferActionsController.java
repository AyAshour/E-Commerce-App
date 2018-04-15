package com.swe.project.controller;

import com.swe.project.entity.Action;
import com.swe.project.entity.Product;
import com.swe.project.service.ProductDiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/Offer")
public class OfferActionsController extends ActionController {
    @Override
    ResponseEntity<?> Add(Action offerAction) {
        return ResponseEntity.ok().build();
    }
}

package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepo;

   /* @RequestMapping("/buy")
   void buyProduct (List<Product> products, ){


    }*/



}

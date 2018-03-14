package com.swe.project.controller;

import com.swe.project.entity.Brand;
import com.swe.project.repository.BrandRepository;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {
    @Autowired
    private BrandRepository brandRepo;

    @PostMapping("/addBrand")
    @ResponseBody
        String addBrand(Brand brand) {
        if(!brandRepo.existsByName(brand.name)) {
            brandRepo.save(brand);
            return "done";
        }
        return  "notDone";
    }
}

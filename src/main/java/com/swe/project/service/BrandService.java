package com.swe.project.service;

import com.swe.project.entity.Brand;
import com.swe.project.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepo;

    public ResponseEntity<?> addBrand(String brandName){
        if(!brandRepo.existsByName(brandName)) {
            Brand brand = new Brand(brandName);
            brandRepo.save(brand);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    public ResponseEntity<?> getAllBrands(){
        Iterable<Brand> brands = brandRepo.findAll();
        if(brands.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(brands);
    }
}

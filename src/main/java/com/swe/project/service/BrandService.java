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

    private BrandRepository brandRepository;
    public boolean addBrand(String brandName){
        if(!brandRepository.existsByName(brandName)) {
            Brand brand = new Brand(brandName);
            brandRepository.save(brand);
            return true;
        }
        return false;
    }
    public Iterable<Brand> getAllBrands(){
        Iterable<Brand> brands = brandRepository.findAll();
        return brands;
    }
}

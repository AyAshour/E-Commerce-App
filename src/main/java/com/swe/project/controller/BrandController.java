package com.swe.project.controller;

import com.swe.project.entity.Brand;
import com.swe.project.entity.Product;
import com.swe.project.repository.BrandRepository;
import com.swe.project.repository.ProductRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private ProductController productController;
    @Autowired
    private  BrandRepository brandRepository;

    @PostMapping("/addBrand")
    @ResponseBody
    ResponseEntity<?> addBrand(@RequestParam String brandName) {
        if (!brandRepository.existsByName(brandName)) {
            Brand brand = new Brand(brandName);
            brandRepository.save(brand);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        Iterable<Brand> brands = brandRepository.findAll();
        if (brands.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(brands);
    }

    public Set<String> mostOrderedBrands(int X) {
        Iterable<Product> products = productController.getProductsOutOfStock();
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        PriorityQueue<Pair<Integer, String>> brandsOrdered = new PriorityQueue<>();
        for (Product product : products) {
            Brand brand = product.brand;
            String name = brand.name;
            if (!mp.containsKey(name)) {
                mp.put(name,1);
            } else {
                mp.put(name, mp.get(name) + 1);
            }
        }
        Set<String> ret = new HashSet<>();
        for (Map.Entry<String, Integer> pair : mp.entrySet()) {
            if (ret.size() == X)
                break;
            ret.add(pair.getKey());
        }
        return ret;
    }
}

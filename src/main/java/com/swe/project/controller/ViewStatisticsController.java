package com.swe.project.controller;

import com.swe.project.entity.Brand;
import com.swe.project.entity.Product;
import com.swe.project.entity.Store;
import com.swe.project.entity.User;
import com.swe.project.repository.StoreRepository;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/ViewStatistics")
public class ViewStatisticsController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductController productController;
    @Autowired
    private BrandController brandController;

    @PostMapping(value = "/store")
    public ResponseEntity<?> StoreStatistics(Integer storeID, int X) {
        Store store = storeRepository.findStoreById(storeID);
        Set<User> viewers = new HashSet<>();
        Set<User> buyers = new HashSet<>();
        Set<Product> soldOutProducts = new HashSet<>();
        for (Product product : store.getProducts()) {
            viewers.addAll(product.viewers);
            if (product.inStock == false) {
                buyers.add(product.buyer);
                soldOutProducts.add(product);
            }
        }
        Integer numberOfUsersViewedTheStoreProduct = viewers.size();
        Integer numberOfUsersBuyTheStoreProducts = buyers.size();
        Set<String> mostOrderedProducts = productController.mostOrderedProducts(X);
        Set<String> mostOrderedBrands = brandController.mostOrderedBrands(X);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> UserStatistics() {
        Set<User> users = (Set<User>) userRepository.findAll();
        Integer sum = users.size();
        return ResponseEntity.ok().body(null);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<?> ProductsStatistics(Integer productID) {
        Product mostOrderedProduct = (Product) productController.mostOrderedProducts(1);
        Product leastOrderedProduct = (Product) productController.leastOrderedProducts(1);
        return ResponseEntity.ok().body(null);
    }
}

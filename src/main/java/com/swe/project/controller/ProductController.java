package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.entity.User;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private static ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        ProductController.productRepository = productRepository;
    }

    @PostMapping("/addProductToSystem")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getProduct(@RequestParam Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        Iterable<Product> productsOptional = productRepository.findAll();
        if (productsOptional.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(productsOptional);
    }

    @PostMapping(value = "/remove")
    public ResponseEntity<?> removeProduct(@RequestParam Integer id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public static Iterable<Product> getProductsOutOfStock() {
        return productRepository.findAllByInStock(false);
    }
    public static Product mostOrderedProduct() {
        Iterable<Product> products = getProductsOutOfStock();
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        Integer mxOrderedProduct = 0;
        Product ret = new Product();
        for (Product p : products) {
            String name = p.name;
            if (!mp.containsKey(name)) {
                mp.put(name, 1);
            } else {
                mp.put(name, mp.get(name) + 1);
            }
            if (mxOrderedProduct < mp.get(name)) {
                mxOrderedProduct = Math.max(mxOrderedProduct, mp.get(name));
                ret = p;
            }
        }
        return ret;
    }

    @PostMapping("/viewProduct")
    public ResponseEntity<?> viewProduct(@RequestParam Integer productID, String userName) {
        Product product = productRepository.findProductById(productID);
        User user = userRepository.findByUsername(userName);
        if (product != null && user != null) {
            product.viewers.add(user);
        }
        return new ResponseEntity<>(null, HttpStatus.FOUND);
    }
}

package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;


    @PostMapping("/addProductToSystem")
    public String addProduct(@RequestParam String name, @RequestParam String priceRange, @RequestParam double price, @RequestParam String category) {
        productRepo.save(new Product(name, priceRange, price, category));
        return "done!";
    }


    /*@PostMapping(value = "/update")
    public Product updateProduct(@RequestParam Integer id, @RequestParam String name, @RequestParam String category, @RequestParam String priceRange, @RequestParam double price) {

        Product p = new Product(name, priceRange, price, category);
        productRepo.updateProductById(id, p);
        return p;
    }*/


    @GetMapping(value = "/get")
    public Product getProduct(@RequestParam Integer id) {
        return productRepo.findProductById(id);
    }

    @GetMapping(value = "/getAll")
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @PostMapping(value = "/remove")
    public void removeProduct(@RequestParam Integer id) {
        productRepo.deleteById(id);
    }

    public Iterable<Product> getProductsOutOfStock() {
        return productRepo.findAllByInStock(false);
    }

    @PostMapping("/viewMostOrdered")
    public Product mostOrderedProduct() {
        Iterable<Product> products = getProductsOutOfStock();
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        Integer mxOrderedProduct = 0;
        Product ret = new Product();
        for (Product p : products) {
            String name = p.getName();
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

}

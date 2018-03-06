package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;


    @PostMapping("/addProductToSystem")
    public String addProduct(@RequestParam String name, @RequestParam String priceRange, @RequestParam double price, @RequestParam String category){
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
    public Product getProduct(@RequestParam Integer id){
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

}

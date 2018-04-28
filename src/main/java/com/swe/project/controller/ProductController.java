package com.swe.project.controller;

import com.swe.project.entity.Brand;
import com.swe.project.entity.Category;
import com.swe.project.entity.Product;
import com.swe.project.repository.ProductRepository;
import com.swe.project.service.BrandService;
import com.swe.project.service.CategoryService;
import com.swe.project.service.ProductService;
import com.swe.project.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addProductToSystem")
    public ResponseEntity<?> addProduct(@RequestBody Product product, @RequestParam("brandId") Integer brandId, @RequestParam("categoryId") Integer categoryId) {
        Brand brand = brandService.getBrandById(brandId);
        Category category = categoryService.getCategoryById(categoryId);

        if(brand == null || category == null)
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        product.setBrand(brand);
        product.setCategory(category);
        productService.addProduct(product);

        return ResponseEntity.ok().build();
    }


    /*@PostMapping(value = "/update")
    public Product updateProduct(@RequestParam Integer id, @RequestParam String name, @RequestParam String category, @RequestParam String priceRange, @RequestParam double price) {

        Product p = new Product(name, priceRange, price, category);
        productRepo.updateProductById(id, p);
        return p;
    }*/


    @GetMapping(value = "/get")
    public ResponseEntity<?> getProduct(@RequestParam Integer id) {
        Product product = productService.getProductById(id);
        if(product != null)
            return ResponseEntity.status(HttpStatus.OK).body(product);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        Iterable<Product> productsOptional = productService.getAll();
        if(productsOptional.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(productsOptional);
    }

    @PostMapping(value = "/remove")
    public ResponseEntity<?> removeProduct(@RequestParam Integer id) {
        productService.removeProduct(id);
        return ResponseEntity.ok().build();
    }

    public Iterable<Product> getProductsOutOfStock() {
        return productService.getProductsOutOfStock();
    }

    @PostMapping("/viewMostOrdered")
    public Product mostOrderedProduct() {
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

    @PostMapping("/buyProduct")
    ResponseEntity<?> buyProduct(@RequestBody Product product, @RequestParam Integer quantity, @RequestParam String address)
    {
        productService.buyProduct(product, quantity);
        if(shippingService.canBeShipped(address)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}

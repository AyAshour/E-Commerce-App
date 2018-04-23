package com.swe.project.controller;


import com.swe.project.entity.Category;
import com.swe.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/addCategory")
    public ResponseEntity<?> addCategory(@RequestParam String name){
        if(categoryRepository.existsByName(name))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Category c = new Category(name);
        categoryRepository.save(c);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getAll(){
        Iterable<Category> categories = categoryRepository.findAll();
        if(categories.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}

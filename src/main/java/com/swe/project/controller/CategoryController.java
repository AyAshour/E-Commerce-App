package com.swe.project.controller;


import com.swe.project.entity.Category;
import com.swe.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @PostMapping(path = "/addCategory")
    public ResponseEntity<?> addCategory(@RequestParam String categoryName){

        if(categoryRepo.existsByName(categoryName))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        Category c = new Category(categoryName);
        categoryRepo.save(c);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getAll(){
        Iterable<Category> categories = categoryRepo.findAll();
        if(categories.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}

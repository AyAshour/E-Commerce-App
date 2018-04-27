package com.swe.project.controller;


import com.swe.project.entity.Category;
import com.swe.project.repository.CategoryRepository;
import com.swe.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/addCategory")
    public ResponseEntity<?> addCategory(@RequestParam String categoryName){
        boolean existCategory = categoryService.addCategory(categoryName);
        if(!existCategory)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getAll(){
        Iterable<Category> categories = categoryService.getAllCategories();
        if(categories.equals(null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}

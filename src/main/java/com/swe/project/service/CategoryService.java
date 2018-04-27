package com.swe.project.service;

import com.swe.project.entity.Category;
import com.swe.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public boolean addCategory(String categoryName){
        if(!categoryRepository.existsByName(categoryName)) {
            Category category = new Category(categoryName);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }
    public Iterable<Category> getAllCategories(){
        Iterable<Category> categories = categoryRepository.findAll();
        return categories;
    }
}

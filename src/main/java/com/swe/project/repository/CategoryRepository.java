package com.swe.project.repository;

import com.swe.project.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    boolean existsByName(String name);
}

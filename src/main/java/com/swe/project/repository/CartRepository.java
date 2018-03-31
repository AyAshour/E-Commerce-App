package com.swe.project.repository;

import com.swe.project.entity.Cart;
import com.swe.project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer>{
    Cart getCartByUser(User user);
    Cart getCartById(Integer id);
}

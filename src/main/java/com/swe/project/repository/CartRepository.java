package com.swe.project.repository;

import com.swe.project.entity.Cart;
import com.swe.project.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
    Cart getCartByUser(User user);
    Cart getCartByCartId(Integer cartId);
}

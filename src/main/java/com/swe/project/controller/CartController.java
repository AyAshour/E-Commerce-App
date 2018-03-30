package com.swe.project.controller;

import com.swe.project.entity.Cart;
import com.swe.project.entity.Product;
import com.swe.project.entity.User;
import com.swe.project.repository.CartRepository;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/addProduct")
    ResponseEntity<?> addProductToCart(@RequestBody Product product, @RequestParam Integer cartId){
        Cart cart = cartRepo.getCartById(cartId);

        cart.getProducts().add(product);
        cartRepo.save(cart);

        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping("/removeProduct")
    ResponseEntity<?> removeProductFromCart(@RequestBody Product product, @RequestParam Integer cartId){
        Cart cart = cartRepo.getCartById(cartId);

        cart.getProducts().remove(product);
        cartRepo.save(cart);

        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping("/assignCartToUser")
    ResponseEntity<?> assignCartToUser(@RequestBody User user){
        Cart cart = new Cart();

        cart.setUser(user);
        cartRepo.save(cart);

        user.setCart(cart);
        userRepo.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping("/getCartByUser")
    ResponseEntity<?> getCart(User user){
        return ResponseEntity.status(HttpStatus.OK).body(cartRepo.getCartByUser(user));
    }
}

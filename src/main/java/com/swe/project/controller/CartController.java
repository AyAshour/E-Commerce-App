package com.swe.project.controller;

import com.swe.project.discounts.Discount;
import com.swe.project.discounts.DiscountFactory;
import com.swe.project.entity.*;
import com.swe.project.repository.CartRepository;
import com.swe.project.repository.ProductRepository;
import com.swe.project.repository.StoreRepository;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private StoreRepository storeRepo;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/buyProducts")
    ResponseEntity<?> buyProducts(@RequestBody Cart cart)
    {

      for(Map.Entry<Integer, Product> storeProduct : cart.getProducts().entrySet()){
          Product product = storeProduct.getValue();
          Integer productId = product.getId();

          Integer storeId = storeProduct.getKey();
          Store store = storeRepo.findStoreById(storeId);

          Integer productQtyInCart = product.getQuantity();
          Integer oldQtyInSystem = productRepo.findProductById(productId).getQuantity();
          productRepo.findProductById(productId).setQuantity(oldQtyInSystem-productQtyInCart);
         for(Product p : store.getProducts() ){
             if(p.getId() == productId){
                 Integer oldQtyInStore = p.getQuantity();
                 p.setQuantity(oldQtyInStore-productQtyInCart);
             }
         }
         storeRepo.save(store);
         productRepo.save(product);
      }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @Autowired
    private DiscountFactory discountFactory;

    @GetMapping("/calculatePrice")
    ResponseEntity<?> calculatePrice(@RequestBody User user, @RequestBody Cart cart){
        double totalPrice = 0;

        // calculate price without discount
        for(Map.Entry<Integer, Product> storeProduct : cart.getProducts().entrySet()){
            totalPrice += storeProduct.getValue().getPrice();
        }

        // apply discount on price
        Discount discount;

         /*for(UserType u : user.getUserRoles()){
              discount = discountFactory.getDiscount();
              totalPrice = discount.applyDiscount(totalPrice);
         }
*/


        return ResponseEntity.status(HttpStatus.OK).body(totalPrice);
    }


    @PostMapping("/addProduct")
    ResponseEntity<?> addProductToCart(@RequestBody Product product, @RequestParam Integer cartId, @RequestParam Integer storeId){
        Cart cart = cartRepo.getCartById(cartId);

        cart.getProducts().put(storeId, product);
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

package com.swe.project.controller;


import com.swe.project.discounts.Discount;
import com.swe.project.discounts.DiscountFactory;
import com.swe.project.entity.*;

import com.swe.project.service.CartService;

import com.swe.project.service.ProductService;
import com.swe.project.service.StoreService;
import com.swe.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    StoreService storeService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @PostMapping("/buyProducts")
    ResponseEntity<?> buyProducts(@RequestBody Cart cart)
    {

      for(Map.Entry<Integer, Product> storeProduct : cart.getProducts().entrySet()){
          Product product = storeProduct.getValue();
          Integer productId = product.getId();

          Integer storeId = storeProduct.getKey();
          Store store = storeService.getStoreById(storeId);

          Integer productQtyInCart = product.getQuantity();
          Integer oldQtyInSystem = productService.getProductById(productId).getQuantity();
          productService.getProductById(productId).setQuantity(oldQtyInSystem-productQtyInCart);
         for(Product p : store.getProducts() ){
             if(p.getId() == productId){
                 Integer oldQtyInStore = p.getQuantity();
                 p.setQuantity(oldQtyInStore-productQtyInCart);
             }
         }
         storeService.addStore(store);
         productService.addProduct(product);
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
        Cart cart = cartService.getCartById(cartId);

        cart.getProducts().put(storeId, product);
        cartService.addCart(cart);

        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping("/removeProduct")
    ResponseEntity<?> removeProductFromCart(@RequestBody Product product, @RequestParam Integer cartId){
        Cart cart = cartService.getCartById(cartId);

        cart.getProducts().remove(product);
        cartService.addCart(cart);

        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @PostMapping("/assignCartToUser")
    ResponseEntity<?> assignCartToUser(@RequestBody User user){
        Cart cart = new Cart();
        cart.setUser(user);
        cartService.addCart(cart);
        user.setCart(cart);
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/getCartByUser")
    ResponseEntity<?> getCart(@RequestBody  User user){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getCartByUser(user));
    }
}

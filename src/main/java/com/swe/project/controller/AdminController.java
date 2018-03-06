package com.swe.project.controller;

import com.swe.project.entity.Product;
import com.swe.project.entity.User;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

   // ProductController pc;

    @Autowired
    UserRepository userRepo;

  /*  boolean isAdmin(Integer id){
        User user = userRepo.findUserById(id);
        if(user.isAdmin())
            return true;
        return false;
    }

    @PostMapping(value = "/{id}/addProduct")
    public boolean addProduct(@PathVariable Integer id, @RequestParam String name, @RequestParam String category, @RequestParam String priceRange, @RequestParam double price) {
        if (isAdmin(id)) {
            Product p = new Product(name, priceRange, price, category);
            pc.addProduct(p);
            return true;
        }
        return false;
    }
*/
  @GetMapping("/login/byUserName")
  public boolean loginByUserName(@RequestParam String username, @RequestParam String password){
      User user = userRepo.findByUsername(username);
      if(!(user == null) && password.equals(user.getPassword()))
          return true;
      return false;
  }

    @GetMapping("/login/byEmail")
    public boolean loginByEmail(@RequestParam String email, @RequestParam String password){
        User user = userRepo.findByEmail(email);
        if(!(user == null) && password.equals(user.getPassword()))
            return true;
        return false;
    }
}

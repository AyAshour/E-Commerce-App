package com.swe.project.controller;

import com.swe.project.entity.User;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;


    @PostMapping (value = "/register")
    public String register(@RequestParam String email, @RequestParam String username, @RequestParam String password){

        if(userRepo.existsByEmail(email))
            return "user already exist!";

        userRepo.save(new User(false, email, username, password));
        return "registered successfully!";
    }

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

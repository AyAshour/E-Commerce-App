package com.swe.project.controller;

import com.swe.project.entity.User;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userRepo.existsByEmail(user.getEmail()) || userRepo.existsByUsername(user.getUsername()))
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // CONFLICT or BAD_REQUEST ?
        userRepo.save(user);
        return ResponseEntity.ok().build();
    }
/*
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User temp;
        if(userRepo.findByUsername(user.getUsername()) != null){
            temp = userRepo.findByUsername(user.getUsername());

            if(temp.getPassword().equals(user.getPassword()))
                return ResponseEntity.ok().build();
        }
        else if(userRepo.findByEmail(user.getEmail()) != null){
            temp = userRepo.findByEmail(user.getEmail());

            if(temp.getPassword().equals(user.getPassword()))
                return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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

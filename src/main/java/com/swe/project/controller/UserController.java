package com.swe.project.controller;

import com.swe.project.entity.User;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/login/byUserName")
    public ResponseEntity<?> loginByUserName(@RequestParam String username, @RequestParam String password){
        User user = userRepo.findByUsername(username);
        if(user != null && password.equals(user.getPassword()))
            return ResponseEntity.ok().body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/login/byEmail")
    public ResponseEntity<?> loginByEmail(@RequestParam String email, @RequestParam String password){
        User user = userRepo.findByEmail(email);
        if(user != null && password.equals(user.getPassword()))
            return ResponseEntity.ok().body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}

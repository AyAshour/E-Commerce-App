package com.swe.project.controller;

import com.swe.project.entity.User;
import com.swe.project.entity.Store;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    @PostMapping("/addCollaborators")
    public void addCollaborators(List<User> users, User owner){
        if(owner.type =="owner") {
            List<User> owners = new ArrayList<>();
            for (User user : users) {
                User user1 = new User("owner", user.email, user.username, user.getPassword());
                owners.add(user1);
            }
            for (Store store : owner.stores) {
                store.addOwners(owners);
            }
            for (User user1 : owners) {
                user1.addStores(owner.stores);
            }

        }
    }

}

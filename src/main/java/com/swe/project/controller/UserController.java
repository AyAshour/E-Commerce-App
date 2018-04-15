package com.swe.project.controller;

import com.swe.project.entity.User;
import com.swe.project.entity.Store;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername()))
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // CONFLICT or BAD_REQUEST ?
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/login/byUserName")
    public ResponseEntity<?> loginByUserName(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword()))
            return ResponseEntity.ok().body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/login/byEmail")
    public ResponseEntity<?> loginByEmail(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword()))
            return ResponseEntity.ok().body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/addCollaborators")
    public void addCollaborators(Set<String> usersID, String ownerID) {
        List<User> users = new ArrayList<>();
        for (String ID : usersID) {
            users.add(userRepository.findByUsername(ID));
        }
        User owner = userRepository.findByUsername(ownerID);
        if (owner.type == "owner") {
            Set<User> owners = new HashSet<>();
            for (User user : users) {
                User user1 = user;
                user1.setType("owner");
                owners.add(user1);
            }
            for (Store store : owner.stores) {
                store.addOwners(owners);
            }
            for (User user1 : owners) {
                user1.addStores(owner.stores);
            }
            owner.addCollaborators(owners);
        }
    }

}

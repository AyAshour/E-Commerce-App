package com.swe.project.service;


import com.swe.project.entity.User;
import com.swe.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean register(User user){
        if(userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUsername(user.getUsername()))
            return false; // CONFLICT or BAD_REQUEST ?
       userRepository.save(user);
        return true;
    }

    public User findByEmail(String email){
        return userRepository.findByUsername(email);
    }
}

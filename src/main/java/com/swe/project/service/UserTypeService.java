package com.swe.project.service;

import com.swe.project.entity.UserType;
import com.swe.project.repository.UserRepository;
import com.swe.project.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public void addUserType(UserType userType){
        if(userTypeRepository.findUserTypeByUserType(userType.getUserType()) == null) {
            userTypeRepository.save(userType);
        }
    }
}

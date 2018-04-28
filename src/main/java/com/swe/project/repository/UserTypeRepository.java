package com.swe.project.repository;


import com.swe.project.entity.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
    UserType findUserTypeByUserType(UserType.Type userType);
}

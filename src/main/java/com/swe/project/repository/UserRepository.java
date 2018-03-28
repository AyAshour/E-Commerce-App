package com.swe.project.repository;

import com.swe.project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}

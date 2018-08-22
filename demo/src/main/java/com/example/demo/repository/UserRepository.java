package com.example.demo.repository;

import com.example.demo.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmailAndPassword(String email, String password);
}

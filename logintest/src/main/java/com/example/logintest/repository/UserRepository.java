package com.example.logintest.repository;

import com.example.logintest.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findOneByEmailAndPassword(String email, String password);
}

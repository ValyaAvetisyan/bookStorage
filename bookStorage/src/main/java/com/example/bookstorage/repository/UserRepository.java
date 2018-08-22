package com.example.bookstorage.repository;

import com.example.bookstorage.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserEntity findOneByEmailAndPassword(String email, String password);
}

package com.example.bookstorage.repository;

import com.example.bookstorage.repository.entity.BookEntity;
import com.example.bookstorage.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <BookEntity, Integer>{
    List<BookEntity> findAllByUserId(UserEntity userEntity);
}

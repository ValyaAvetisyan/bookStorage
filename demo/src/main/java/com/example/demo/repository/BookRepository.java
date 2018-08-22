package com.example.demo.repository;

import com.example.demo.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Book repository
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTakenFalse();
}

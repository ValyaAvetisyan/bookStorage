package com.example.demo.service;

import com.example.demo.model.BookDto;
import com.example.demo.model.UserDto;

import java.util.List;

/**
 * Created by home on 8/12/18.
 */
public interface BookService {
    List<BookDto> findAll();
    void addBook(BookDto bookDto);
    void delete(BookDto bookDto);
    BookDto findOneById(long id);
    List<BookDto> findByTakenFalse();
}

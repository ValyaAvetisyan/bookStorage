package com.example.bookstorage.service;

import com.example.bookstorage.model.BookDto;
import com.example.bookstorage.model.UserDto;

import java.util.List;

public interface BookService {
    void addBook(BookDto bookDto);
    List<BookDto> findAll() ;
    List<BookDto> findAllByUserId(UserDto userDto);
}

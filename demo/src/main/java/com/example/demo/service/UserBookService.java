package com.example.demo.service;

import com.example.demo.model.UserBookDto;
import com.example.demo.repository.entity.UserBook;

import java.util.List;

public interface UserBookService {
    List<UserBookDto> findAll();
    void saveUserBook(UserBookDto userBookDto);
}

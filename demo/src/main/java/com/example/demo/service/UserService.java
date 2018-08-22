package com.example.demo.service;

import com.example.demo.model.UserDto;

import java.util.List;

/**
 * Created by home on 8/12/18.
 */
public interface UserService {
    UserDto getUserByEmailAndPassword(String email, String password);
    List<UserDto> findAll();
    void addUser(UserDto userDto);
    UserDto findOneById(long id);
    void delete(UserDto userDto);
}

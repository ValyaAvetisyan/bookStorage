package com.example.logintest.serviice;

import com.example.logintest.model.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserByEmailAndPassword(String email, String password);
    List<UserDto> findAll();
    void addUser(UserDto userDto);
    UserDto findOneById(int id);
   void delete(UserDto userDto);

}

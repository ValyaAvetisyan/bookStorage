package com.example.bookstorage.model.mapper;


import com.example.bookstorage.model.UserDto;
import com.example.bookstorage.repository.entity.UserEntity;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface UserMapper {

    UserDto asUserDto(UserEntity in);
    UserEntity asUser(UserDto in);

}
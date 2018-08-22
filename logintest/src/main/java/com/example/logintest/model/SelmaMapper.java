package com.example.logintest.model;
import com.example.logintest.repository.entity.UserEntity;
import fr.xebia.extras.selma.Mapper;

@Mapper
public interface SelmaMapper {

    // This will build a fresh new USerDto
    UserDto asUserDto(UserEntity in);

    // This will update the given user
    UserEntity asUser(UserDto in);

}
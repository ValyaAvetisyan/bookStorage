package com.example.demo.model;

import com.example.demo.repository.entity.Book;
import com.example.demo.repository.entity.User;
import com.example.demo.repository.entity.UserBook;
import fr.xebia.extras.selma.Mapper;
import jdk.nashorn.internal.ir.annotations.Ignore;

@Mapper
public interface SelmaMapper {

    User toUser(UserDto to);

    UserDto toUserDto(User to);

    Book toBook(BookDto to);

    BookDto toBookDto(Book to);

    UserBook toUserBook(UserBookDto to);

    UserBookDto toUserBookDto(UserBook to);
}

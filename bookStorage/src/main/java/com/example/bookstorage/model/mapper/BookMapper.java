package com.example.bookstorage.model.mapper;

import com.example.bookstorage.model.BookDto;
import com.example.bookstorage.repository.entity.BookEntity;
import fr.xebia.extras.selma.Mapper;
@Mapper
public interface BookMapper {

    BookDto asBookDto (BookEntity in);
    BookEntity asBookEntity (BookDto in);

}

package com.example.bookstorage.service;

import com.example.bookstorage.model.BookDto;
import com.example.bookstorage.model.UserDto;
import com.example.bookstorage.model.mapper.BookMapper;
import com.example.bookstorage.model.mapper.UserMapper;
import com.example.bookstorage.repository.BookRepository;
import com.example.bookstorage.repository.entity.BookEntity;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    BookMapper mapper = Selma.builder(BookMapper.class).build();
    UserMapper userMapper = Selma.builder(UserMapper.class).build();
    @Override
    public void addBook(BookDto bookDto) {
        bookRepository.save(mapper.asBookEntity(bookDto));
    }

    @Override
    public List<BookDto> findAll(){
        List<BookEntity> books= bookRepository.findAll();
        if (!books.isEmpty()) {
            return books.stream().map(u -> mapper.asBookDto(u)).collect(Collectors.toList());
        }



        return new ArrayList<>();
    }


    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {

        }
    });
    @Override
    public List<BookDto> findAllByUserId(UserDto userDto) {
      List<BookEntity> books = bookRepository.findAllByUserId(userMapper.asUser(userDto));
      if (!books.isEmpty()){
          return books.stream().map(u -> mapper.asBookDto(u)).collect(Collectors.toList());
      }
        return new ArrayList<>();
    }
}

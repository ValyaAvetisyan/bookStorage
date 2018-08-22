package com.example.demo.service.impl;

import com.example.demo.model.BookDto;
import com.example.demo.model.SelmaMapper;
import com.example.demo.model.UserDto;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.entity.Book;
import com.example.demo.repository.entity.User;
import com.example.demo.service.BookService;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    private SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        if (!books.isEmpty()){
            return books.stream().map(u->mapper.toBookDto(u)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public void addBook(BookDto bookDto) {
        bookRepository.save(mapper.toBook(bookDto));
    }

    @Override
    public void delete(BookDto bookDto) {
        bookRepository.delete(mapper.toBook(bookDto));

    }

    @Override
    public BookDto findOneById(long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            return mapper.toBookDto(byId.get());
        }
        return new BookDto();

    }

    @Override
    public List<BookDto> findByTakenFalse() {
    List<Book> books = bookRepository.findByTakenFalse();
    if (!books.isEmpty()){
        return books.stream().map(u->mapper.toBookDto(u)).collect(Collectors.toList());
    }
        return new ArrayList<>();
    }
}

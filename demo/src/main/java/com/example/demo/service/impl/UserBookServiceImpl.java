package com.example.demo.service.impl;

import com.example.demo.model.SelmaMapper;
import com.example.demo.model.UserBookDto;
import com.example.demo.repository.UserBookRepository;
import com.example.demo.repository.entity.UserBook;
import com.example.demo.service.UserBookService;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    UserBookRepository userBookRepository;
    SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();

    @Override
    public List<UserBookDto> findAll() {
        List<UserBook> userBooks = userBookRepository.findAll();
        if (!userBooks.isEmpty()) {
            return userBooks.stream().map(u -> mapper.toUserBookDto(u)).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }


    @Override
    public void saveUserBook(UserBookDto userBookDto) {
        userBookRepository.save(mapper.toUserBook(userBookDto));

    }
}

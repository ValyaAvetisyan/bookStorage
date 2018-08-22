package com.example.demo.service.impl;

import com.example.demo.model.SelmaMapper;
import com.example.demo.model.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.User;
import com.example.demo.service.UserService;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by home on 8/12/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    private SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();


    @Override
    public UserDto getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findOneByEmailAndPassword(email, password);
        if (user != null) {
            return mapper.toUserDto(user);
        }
        return new UserDto();
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return users.stream().map(e -> mapper.toUserDto(e)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public void addUser(UserDto userDto) {
        userRepository.save(mapper.toUser(userDto));
    }

    @Override
    public UserDto findOneById(long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return mapper.toUserDto(byId.get());
        }
        return new UserDto();
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(mapper.toUser(userDto));
    }
}


package com.example.logintest.serviice;

import com.example.logintest.model.SelmaMapper;
import com.example.logintest.model.UserDto;
import com.example.logintest.repository.UserRepository;
import com.example.logintest.repository.entity.UserEntity;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
  private   UserRepository userRepository;
    private SelmaMapper mapper= Selma.builder(SelmaMapper.class).build();

    @Override
    public UserDto getUserByEmailAndPassword(String email, String password) {
        UserEntity user = userRepository.findOneByEmailAndPassword(email, password);
        if (user != null) {
            return mapper.asUserDto(user);
        }
        return new UserDto();
    }

    @Override
    public List<UserDto> findAll() {
            List<UserEntity> users = userRepository.findAll();
            if (!users.isEmpty()) {
            return users.stream().map(u -> mapper.asUserDto(u)).collect(Collectors.toList());
            }
            return new ArrayList<>();
        }

    @Override
    public void addUser(UserDto userDto) {
        userRepository.save(mapper.asUser(userDto));
    }

    @Override
    public UserDto findOneById(int id) {
            Optional<UserEntity> byId = userRepository.findById(id);
            if (byId.isPresent()) {
                return mapper.asUserDto(byId.get());
            }
            return new UserDto();
        }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(mapper.asUser(userDto));
    }
}




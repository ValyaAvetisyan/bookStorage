package com.example.demo.controller;

import com.example.demo.model.UserDto;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String login(ModelMap map) {
        map.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping(value = "/addUser")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto){
        userDto.setUserRole(UserRole.USER);
        userService.addUser(userDto);
        return "redirect:/home";
    }
}

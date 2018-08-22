package com.example.bookstorage.controller;

import com.example.bookstorage.model.UserDto;
import com.example.bookstorage.service.BookService;
import com.example.bookstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @GetMapping(value = "/")
    public String login(ModelMap map) {
        map.addAttribute("users", userService.findAll());
        map.addAttribute("user", new UserDto());
        return "index";
    }

    @GetMapping("/login")
    public String finOne(String email, String password) {
        UserDto oneUser = userService.getUserByEmailAndPassword(email, password);
        if (oneUser != null && oneUser.getEmail().equals(email) && oneUser.getPassword().equals(password)) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home (ModelMap map) {
        map.addAttribute("users", userService.findAll());
        map.addAttribute("user", new UserDto());

        return "home";
    }
}

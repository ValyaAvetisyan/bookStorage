package com.example.bookstorage.controller;

import com.example.bookstorage.model.UserDto;
import com.example.bookstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "saveUser")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto){
        userService.addUser(userDto);
        return "redirect:/home";
    }

    @GetMapping("/editPage")
    public String editUser(ModelMap map, @RequestParam("id") int id ) {
        map.addAttribute("user", userService.findOneById(id));
        return "edit";
    }

    @GetMapping("/deleteUser")
    public String deleteStudent(@RequestParam("id") int id) {
        UserDto user = userService.findOneById(id);
        userService.delete(user);
        return "redirect:/home";
    }
    @PostMapping("/updateUser")
    public  String updateUser(@RequestParam("id") int id){
        UserDto user = userService.findOneById(id);
        user.setId(id);
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        userService.addUser(user);
        return "redirect:/editPage";
    }
}

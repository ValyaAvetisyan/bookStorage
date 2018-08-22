package com.example.logintest.controller;

import com.example.logintest.model.UserDto;
import com.example.logintest.serviice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.addUser(userDto);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String allUsers(ModelMap map) {
        map.addAttribute("users", userService.findAll());
        map.addAttribute("user", new UserDto());
        return "home";
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

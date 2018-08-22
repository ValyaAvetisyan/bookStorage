package com.example.demo.controller;

import com.example.demo.model.UserDto;
import com.example.demo.model.UserLoginCmd;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model, @ModelAttribute("userForm") UserLoginCmd user) {
        model.addAttribute("createAccount", "Create account :");
        return "/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(Model model, HttpSession session, @ModelAttribute("userForm") UserLoginCmd loginCmd) {
        if (loginCmd == null || StringUtils.isEmpty(loginCmd.getEmail()) || StringUtils.isEmpty(loginCmd.getPassword())) {
            model.addAttribute("errorMessage", "Wrong credentials");
            return "/login";
        }
        UserDto user = userService.getUserByEmailAndPassword(loginCmd.getEmail(), loginCmd.getPassword());
        if (user != null && user.getId() != null) {
            if (user.getUserRole().equals(UserRole.ADMIN)){
                session.setAttribute("loggedUser", user);
                return "redirect:/admin";
            }
            session.setAttribute("loggedUser", user);
            return "redirect:/home";
        }
        model.addAttribute("errorMessage", "Wrong username or password");
        return "/login";
    }
}
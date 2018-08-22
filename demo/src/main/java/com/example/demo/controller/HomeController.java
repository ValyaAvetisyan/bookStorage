package com.example.demo.controller;

import com.example.demo.model.BookDto;
import com.example.demo.model.UserBookDto;
import com.example.demo.model.UserDto;
import com.example.demo.service.BookService;
import com.example.demo.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserBookService userBookService;

    @GetMapping("/home")
    public String home(ModelMap map) {
        map.addAttribute("books", bookService.findByTakenFalse());
        return "home";
    }


    @GetMapping("home/takeIt")
    public String takeIt(ModelMap map, @RequestParam("id") long id, HttpSession session) {
//        if (id < 0) {
////            also add validation message
//            map.addAttribute("books", bookService.findByTakenFalse());
//            return "home";
//        }
//        UserDto loggedUser = (UserDto) session.getAttribute("loggedUser");
//
//        BookDto book = bookService.findOneById(id);
//
//        if (book != null && book.getBin() != null && book.getId() > 0) {
//            book.setTaken(true);
//            bookService.addBook(book);
//            UserBookDto userBookDto = new UserBookDto(loggedUser, book, new Date(System.currentTimeMillis()));
//            userBookService.saveUserBook(userBookDto);
//        }

        return "redirect:/home";
    }
}
package com.example.demo.controller;

import com.example.demo.model.BookDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/admin")
    public String adminPage(ModelMap map) {
        map.addAttribute("book", new BookDto());
        map.addAttribute("books", bookService.findAll());
        return "admin";
    }

    @PostMapping("/admin/addBook")
    public String addBook(@ModelAttribute("book") BookDto bookDto) {
        bookDto.setTaken(false);
        bookService.addBook(bookDto);
        return "redirect:/admin";
    }
    @GetMapping("/admin/deleteBook")
    public String deleteBook(@RequestParam("id") long id){
      BookDto book = bookService.findOneById(id);
      bookService.delete(book);
        return "redirect:/admin";
    }

    @GetMapping("/admin/editBook")
    public String editBook(@RequestParam("id") long id, ModelMap map) {
        map.addAttribute("book", bookService.findOneById(id));
        return "editBook";
    }

    @PostMapping("/admin/updateBook")
    public String updateBook(@ModelAttribute("book") BookDto book, @RequestParam("id") long id) {
        book.setId(id);
        bookService.addBook(book);
        return "redirect:/admin";

    }
}

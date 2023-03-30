package com.cb.controller;

import com.cb.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/register")
    public String showRegister(){
        return "BookRegister";
    }

    @GetMapping("/show")
    public String showBook(Model model){
        Book book = new Book(10,"Core Java","Dhruv Kumar",10000D);
        model.addAttribute("th",book);
        model.addAttribute("user","Dhruv Kumar");
        return "Book";
    }
}

package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/data")
    public String getData( Model model){
        model.addAttribute("prodcode","Sample ABCD");
        return "ProductData";
    }
}

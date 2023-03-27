package com.cb.controller;

import com.cb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("name", "Dhruv Kumar");
        return "UserHome";
    }



    @GetMapping("/record")
    public String showUserObj(Model model){
        User user = new User(10,"Dhruv","Developer");
        List<User> users = List.of(
                        new User(10,"Dhruv","Developer"),
                        new User(11,"Purushottam","Developer"),
                        new User(12,"Satish","Developer"),
                        new User(13,"Ahmad","Developer")
        );

        model.addAttribute("usr",user);
        model.addAttribute("usrs",users);

        return "UserData";
    }
}

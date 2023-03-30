package com.cb.controller;

import com.cb.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/show/regPage")
    public String showRegistration(){
        return "EmpRegister";
    }

    @PostMapping("/read/data")
    public String readData(@ModelAttribute Employee employee,
                    Model model
                    ){
        model.addAttribute("emp",employee);
        return "EmployeePage";
    }
}

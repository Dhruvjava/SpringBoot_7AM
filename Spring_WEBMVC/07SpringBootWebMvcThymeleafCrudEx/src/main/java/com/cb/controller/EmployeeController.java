package com.cb.controller;

import com.cb.entity.Employee;
import com.cb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;


    /***
     * 0. This Method will return HomePage.
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getHomePage(/*@ModelAttribute("model")Model status,*/
                    Model model, @RequestParam(value = "status", required = false) String status) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("emps", employees);
        if (status != null) {
            model.addAttribute("status", status);
        }
        if (employees.size() > 0 && status == null) {
            model.addAttribute("status", "Registered employees are retrieved.");
        } else if (employees.size() == 0 && status == null) {
            model.addAttribute("status", "No Employees are registered.");
        }
        return "EmployeeHome";
    }

    /***
     * 1. SHOW REGISTER PAGE
     * This method is used to show register page when
     * end-user enters /register url with GET type
     */

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("status", "Employee is Restering...");
        //        System.out.println(model);
        return "EmployeeRegister";
    }

    /***
     * 2. This Method will save Employee Data
     */

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee, Model model,
                    RedirectAttributes attributes) {
        String status = service.saveEmployee(employee);
        model.addAttribute("status", status);
        attributes.addAttribute("status", status);
        return "redirect:/emp/";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Integer id,
                    RedirectAttributes attributes) {
        String status = service.deleteEmployee(id);
        attributes.addAttribute("status", status);
        return "redirect:/emp/";
    }

    @GetMapping("/update/page")
    public String updateEmployeePage(@RequestParam("id") Integer id, Model model) {
        Employee employee = service.getOneEmployee(id);
        model.addAttribute("emp", employee);
        return "EmployeeUpdate";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee,
                    RedirectAttributes attributes) {
        String status = service.updateEmployee(employee);
        attributes.addAttribute("status", status);
        return "redirect:/emp/";
    }

}

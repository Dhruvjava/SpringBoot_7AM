package com.cb.runners;

import com.cb.entity.Employee;
import com.cb.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestCFetchPageRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        List<Employee> list = employeeService.getPageResult(0,4);
        list.forEach(System.out::println);
    }
}

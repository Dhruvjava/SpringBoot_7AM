package com.cb.runners;

import com.cb.entity.Employee;
import com.cb.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Order(10)
public class TestASaveRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeService service;

    @Override
    public void run(String... args) throws Exception {
    String result=service.saveEmployees(Arrays.asList(
                    new Employee(10,"john",300,"DEV"),
                    new Employee(11,"smith",100,"QA"),
                    new Employee(12,"Sample",200,"BA"),
                    new Employee(13,"ABC",300,"DEV"),
                    new Employee(14,"XYZ",200,"QA"),
                    new Employee(15,"GHI",100,"BA"),
                    new Employee(16,"PQR",300,"DEV"),
                    new Employee(17,"STU",100,"QA"),
                    new Employee(18,"DEF",200,"BA"),
                    new Employee(19,"JKL",300,"DEV"),
                    new Employee(20,"MNO",100,"QA")
    ));
        System.out.println(result);
    }
}

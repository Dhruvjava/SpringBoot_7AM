package com.cb.runners;

import com.cb.entity.Employee;
import com.cb.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Order(20)
public class TestBFetchRunner implements CommandLineRunner {

    @Autowired
    private IEmployeeService service;

    @Override
    public void run(String... args) throws Exception {
        List<Employee> list1 = service.findAll();
        list1.forEach(System.out::println);


        // --case-1 -- 1 Column -- ASC Order--------------------------------
        List<Employee> list2 = service.findAll(Sort.by(Sort.Direction.DESC, "sal", "dept"));
        list2.forEach(System.out::println);
        // -- case 2 -- 2 column -- mixed order like asc or desc ------------
        List<Employee> list3 = service.findAll(Sort.by(Sort.Order.asc("sal"), Sort.Order.desc("dept")));
        list3.forEach(System.out::println);

    }
}

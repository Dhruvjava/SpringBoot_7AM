package com.cb.runners;

import com.cb.entity.Department;
import com.cb.entity.Employee;
import com.cb.repo.DepartmentRepo;
import com.cb.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private DepartmentRepo deptRepo;

    @Override
    public void run(String... args) throws Exception {

        Department dept = new Department(null, "Dev", "Girish.M");
        deptRepo.save(dept);
        System.out.println("Department Saved !!!");
        Employee e1 = new Employee(null, "Dhruv Kumar",500D,dept);
        Employee e2 = new Employee(null, "Chaitanya.g",500D,dept);
        Employee e3 = new Employee(null, "Sekhar",500D,dept);

        repo.saveAll(List.of(e1,e2,e3));
        System.out.println("Data Saved !!!");

        repo.findAll().forEach(System.out::println);
    }
}

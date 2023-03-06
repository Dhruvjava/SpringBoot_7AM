package com.cb.runners;

import com.cb.entity.Employee;
import com.cb.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmployeeASaveRunner implements CommandLineRunner {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public void run(String... args) throws Exception {

        repo.saveAll(Arrays.asList(new Employee(null, "Dhruv", 26200D, "DEV"),
                        new Employee(null, "Ankit", 26200D, "DEV"),
                        new Employee(null, "Chaitanya", 26200D, "DEV"),
                        new Employee(null, "Sekhar", 26200D, "DEV"),
                        new Employee(null, "Rajesh", 26200D, "JR. DEV"),
                        new Employee(null, "Raju", 26200D, "JR. DEV"),
                        new Employee(null, "Anil", 126200D, "UI Manager"),
                        new Employee(null, "Ravi", 106200D, "UI Expert"),
                        new Employee(null, "Shiva Teja", 106200D, "SR. Ui DEV"),
                        new Employee(null, "Maneesha", 106200D, "SR. UI DEV"),
                        new Employee(null, "Manikanta", 106200D, "SR. Tester"),
                        new Employee(null, "Pawan", 126200D, "DevOPs Eng."),
                        new Employee(null, "Raj Sekhar", 106200D, "SR. DEV"),
                        new Employee(null, "Swammy", 132000D, "Manager")));
        System.out.println("---- Employee Saved !!! ----");

//        System.out.println("---- fetch all employee NAme records ----");
//        repo.getAllEmployeesName().forEach(System.out::println);
//
//        System.out.println("---- fetch Employee All Cols Recprds ----");
//
//        repo.getAllEmployees().forEach(System.out::println);
//
//        System.out.println("---- get Multiple col Records ----");
//
//        repo.getMultipleFields().stream()
//                        .map(obj -> "Name :" + obj[0] + " Salary :" + obj[1] + " Dept :" + obj[2])
//                        .forEach(System.out::println);
//
//        System.out.println("---- get One Row Object Based on empId ----");
//        System.out.println(repo.getOneName(1).orElse("No Data Present !!"));

        repo.getCoundByDept().stream().map(obj -> "Dept_Name : "+obj[0]+" count : "+obj[1]).forEach(System.out::println);

        System.out.println(repo.getMinSal());

        System.out.println(repo.getMaxSal());

        System.out.println(repo.getAvgSal());

    }
}

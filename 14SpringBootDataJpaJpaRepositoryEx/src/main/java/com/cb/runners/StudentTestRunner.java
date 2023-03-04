package com.cb.runners;

import com.cb.entity.Student;
import com.cb.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class StudentTestRunner implements CommandLineRunner {

    @Autowired
    private IStudentRepo repo;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Dhruv kumar");
        s1.setFees(4400.0);
        s1.setDoj(new Date());
        repo.save(s1);

        List<Student> list = repo.findAll();
        list.forEach(System.out::println);

        Student sob = new Student(null,null,400D,null);
        Example<Student> pro = Example.of(sob);
        System.out.println("---- find all with fees greater or equal ----");
//        List<Student> ch =repo.findAllIsGreaterThanOrEqual(pro);
//        ch.forEach(System.out::println);
    }
}

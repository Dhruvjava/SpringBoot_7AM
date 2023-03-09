package com.cb.runners;

import com.cb.entity.Course;
import com.cb.entity.Student;
import com.cb.repo.CourseRepo;
import com.cb.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private CourseRepo cRepo;

    @Autowired
    private StudentRepo srepo;

    @Override
    public void run(String... args) throws Exception {
        Course c1 = new Course(null, "OCJC","java");
        Course c2 = new Course(null, "SQL","SQL");
        Course c3 = new Course(null, "SP","Spring Framework");
        Course c4 = new Course(null, "SCSB","Spring Core & Spring Boot");
        Course c5 = new Course(null, "SB","Spring Boot");
        Course c6 = new Course(null, "SBMS","Spring Boot & Microservices");
        cRepo.saveAll(List.of(c1, c2, c3, c4, c5,c6));
        System.out.println("Course is saved successfully !!!");

        Student s1 = new Student(null, "Chaitanya",5000D, List.of(c1,c2,c3));
        Student s2 = new Student(null, "Dhruv Kumar",50000D, List.of(c1,c4,c5,c6));
        Student s3 = new Student(null, "Sekhar",5000D, List.of(c1,c2,c3));
        Student s4 = new Student(null, "Rajesh",2000D, List.of(c2));
        Student s5 = new Student(null, "Purusottam",20000D, List.of(c1,c5,c4));
        srepo.saveAll(List.of(s1,s2,s3,s4,s5));
        System.out.println("Student has registered !!!");

        srepo.findAll().forEach(System.out::println);
    }
}

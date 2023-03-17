package com.cb.runners;

import com.cb.entity.Role;
import com.cb.entity.User;
import com.cb.repo.RoleRepo;
import com.cb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private UserRepo uRepo;

    @Autowired
    private RoleRepo rRepo;

    @Override
    public void run(String... args) throws Exception {
        Role r1 = new Role(101,"Admin");
        Role r2 = new Role(102,"DEV");
        Role r3 = new Role(103,"QA");
        Role r4 = new Role(104,"HR");

//        rRepo.saveAll(List.of(r1,r2,r3,r4));

        System.out.println("Roles has created successfully !!!");

        User u1 = new User(10,"Dhruv Kumar",List.of(r1,r2));
        User u2 = new User(11,"Ankit",List.of(r3,r4));
        User u3 = new User(12,"Chaitanya",List.of(r2,r3));
        User u4 = new User(13,"Sekhar",List.of(r4));
        uRepo.saveAll(List.of(u1,u2,u3,u4));
        System.out.println("User has Registered with Roles !!!");

        uRepo.findAll().forEach(System.out::println);
//        uRepo.findAll();
    }
}

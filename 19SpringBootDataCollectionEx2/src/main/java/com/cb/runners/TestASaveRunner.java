package com.cb.runners;

import com.cb.entity.AUser;
import com.cb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestASaveRunner implements CommandLineRunner {

    @Autowired
    private UserRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new AUser(null, "Dhruv Kumar", List.of("Admin", "Developer")));
        System.out.println("Data Saved !!!");
    }
}

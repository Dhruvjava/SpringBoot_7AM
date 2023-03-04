package com.cb.runner;

import com.cb.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements CommandLineRunner {

    @Autowired
    private Database db;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(db);
    }
}

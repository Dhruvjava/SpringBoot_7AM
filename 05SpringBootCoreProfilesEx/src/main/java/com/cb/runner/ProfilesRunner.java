package com.cb.runner;

import com.cb.DatabaseCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfilesRunner implements CommandLineRunner {

    @Autowired
    private DatabaseCon con;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("From Profiles Runners !! : "+ con);
    }
}

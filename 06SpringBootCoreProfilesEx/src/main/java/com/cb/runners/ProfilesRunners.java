package com.cb.runners;

import com.cb.DatabaseCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfilesRunners implements CommandLineRunner {

    @Autowired
    private DatabaseCon con;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("From Profiles Runners : "+con);
    }
}

package com.cb.runners;

import com.cb.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class ProfilesRunner implements CommandLineRunner {

    @Autowired
    private Database db;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(db);
    }
}

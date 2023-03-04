package com.cb.runners;

import com.cb.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class EmailRunner implements CommandLineRunner {

    @Autowired
    private Email emails;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("From Email Profile : "+emails);
    }
}

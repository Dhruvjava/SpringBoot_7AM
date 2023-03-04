package com.cb.runners;

import com.cb.UserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"qa","prod"})
public class UserRegRunner implements CommandLineRunner {

    @Autowired
    private UserReg user;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(user);
    }
}

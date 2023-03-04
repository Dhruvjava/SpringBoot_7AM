package com.cb.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(15)
public class DatabaseRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATABASE CON RUNNER !!");
    }
}

package com.cb.runner;

import com.cb.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DatabaseRunner implements CommandLineRunner {

    @Autowired
    private Database database;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(database);
    }
}

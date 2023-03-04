package com.cb.runner;

import com.cb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MailRunner implements CommandLineRunner {

    @Autowired
    private EmailService service;

    @Override
    public void run(String... args) throws Exception {
    service.sendEmail("dhruv.rbs.java@gmail.com","testing","This message is generate for testing... to show Sekhar rajana.");
    }
}

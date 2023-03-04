package com.cb;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext sb = SpringApplication.run(Application.class, args);
        System.out.println(sb.getClass().getName());

//        SpringApplication sp = new SpringApplication(Application.class);
//        sp.setBannerMode(Banner.Mode.OFF);
//        sp.run(args);

    }

}

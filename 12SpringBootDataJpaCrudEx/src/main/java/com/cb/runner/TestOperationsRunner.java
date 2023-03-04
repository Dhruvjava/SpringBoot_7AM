package com.cb.runner;

import com.cb.entity.Product;
import com.cb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class TestOperationsRunner implements CommandLineRunner {

    @Autowired
    private ProductRepo pRepo;

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(pRepo.getClass().getName());

        Product p1=new Product(null,"p1",100);
        Product prod=pRepo.save(p1);
        System.out.println(prod);



    }
}

package com.cb.runners;

import com.cb.entity.Product;
import com.cb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Component
public class TestASaveRunner implements CommandLineRunner {

    @Autowired
    private ProductRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Product(null, "Pen", Arrays.asList("Red", "Black", "Blue"),
                        Set.of("xyz", "ABC", "GHI"),
                        Map.of("type", "Pen", "style", "Avg", "colors", "multi_color")));

        System.out.println("Data Saved !!!");
    }
}

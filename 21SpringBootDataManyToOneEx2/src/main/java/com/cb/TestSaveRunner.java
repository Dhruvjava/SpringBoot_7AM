package com.cb;

import com.cb.entity.Product;
import com.cb.entity.Vendor;
import com.cb.repo.ProductRepo;
import com.cb.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private VendorRepo vRepo;

    @Autowired
    private ProductRepo pRepo;

    @Override
    public void run(String... args) throws Exception {
        Vendor v1 = new Vendor(null, "Apple", "Steve");

        vRepo.save(v1);
        System.out.println("Vendor Created Successfully !!!");
        Product p1 = new Product(null, "iPhone",110000D, v1);
        Product p2 = new Product(null, "Air",90000D, v1);
        Product p3 = new Product(null, "Pro",139000D, v1);
        Product p4 = new Product(null, "Pro M1 pro",199000D, v1);
        Product p5 = new Product(null, "Tab",75000D, v1);
        pRepo.saveAll(List.of(p1,p2,p3,p4,p5));

        System.out.println("Product is created !!!");
    }
}

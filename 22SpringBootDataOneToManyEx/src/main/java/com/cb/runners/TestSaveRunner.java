package com.cb.runners;

import com.cb.entity.Model;
import com.cb.entity.Product;
import com.cb.repo.ModelRepo;
import com.cb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private ModelRepo mrepo;

    @Autowired
    private ProductRepo pRepo;

    @Override
    public void run(String... args) throws Exception {

        Model m1 = new Model(null, "S","S-10");
        Model m2 = new Model(null, "S","S-11");
        Model m3 = new Model(null, "S","S-12");
        Model m4 = new Model(null, "S","S-13");
        Model m5 = new Model(null, "S","S-14");
        Model m6 = new Model(null, "S","S-15");
        Model m7 = new Model(null, "S","S-17");
        Model m8 = new Model(null, "S","S-17");
        Model m9 = new Model(null, "S","S-20");

        mrepo.saveAll(List.of(m1,m2,m3,m4,m5,m6,m7,m8,m9));

        System.out.println("Model has created !!!");

        Product p1 = new Product(null, "Smartphone", List.of(m1,m2,m3,m4,m5,m6,m7,m8,m9));

        pRepo.save(p1);

        System.out.println("Product has created !!!");

    }
}

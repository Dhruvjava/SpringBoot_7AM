package com.cb.runners;

import com.cb.entity.Product;
import com.cb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestSaveRunner implements CommandLineRunner {

    @Autowired
    private ProductRepo prepo;

    @Override
    public void run(String... args) throws Exception {
        prepo.save(new Product(null, "CJ","Core_Java"));
        System.out.println("______________________");
        Product p = prepo.findByPcode("CJ");
        int count=prepo.updateNameById("Spring_Boot",p.getPid());
        System.out.println(count);
        System.out.println("**********************");

        prepo.findAll().forEach(System.out::println);
        System.out.println("++++++++++++++++++++++");
        int dlt = prepo.removeById(p.getPid());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(dlt);
    }
}

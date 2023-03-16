package com.cb.repo;

import com.cb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends JpaRepository<Product, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Product SET pname=:pn WHERE pid=:pd")
    int updateNameById(String pn, String pd);

    @Transactional
    @Modifying
    @Query("DELETE Product WHERE pid=:id")
    int removeById(String id);

    Product findByPcode(String code);
}

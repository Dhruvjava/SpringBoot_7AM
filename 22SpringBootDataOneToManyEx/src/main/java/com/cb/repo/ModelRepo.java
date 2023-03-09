package com.cb.repo;

import com.cb.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Integer> {
}

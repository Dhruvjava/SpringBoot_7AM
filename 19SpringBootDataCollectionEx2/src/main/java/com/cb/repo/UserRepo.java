package com.cb.repo;

import com.cb.entity.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AUser, Integer> {
}

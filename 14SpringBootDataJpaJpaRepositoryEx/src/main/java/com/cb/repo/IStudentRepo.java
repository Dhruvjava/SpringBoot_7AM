package com.cb.repo;

import com.cb.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepo extends JpaRepository<Student,Integer> {

//    @Override
//     List<Student> findAllByFeesIsGreaterThanEqual(Example<Student> example);

//    List<Student> findAllIsGreaterThanOrEqual(Example<Student> example);
}

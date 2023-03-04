package com.cb.repo;

import com.cb.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> ,
                CrudRepository<Employee, Integer> {
}

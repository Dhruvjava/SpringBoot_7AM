package com.cb.services;

import com.cb.entity.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IEmployeeService {

    public String saveEmployees(List<Employee> employee);

    public List<Employee> findAll();

    public List<Employee> findAll(Sort sort);

    public List<Employee> getPageResult(int pageNum, int pageSize);
}

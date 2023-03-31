package com.cb.service;

import com.cb.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(Integer id);

    public Employee getOneEmployee(Integer id);

    public List<Employee> getAllEmployees();

    public Page<Employee> getAllEmployees(Pageable pageable);


}

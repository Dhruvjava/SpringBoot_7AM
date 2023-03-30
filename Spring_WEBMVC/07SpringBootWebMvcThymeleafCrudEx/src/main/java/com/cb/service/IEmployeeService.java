package com.cb.service;

import com.cb.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(Integer id);

    public Employee getOneEmployee(Integer id);

    public List<Employee> getAllEmployees();


}

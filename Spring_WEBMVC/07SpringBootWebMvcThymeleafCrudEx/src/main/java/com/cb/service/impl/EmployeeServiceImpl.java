package com.cb.service.impl;

import com.cb.entity.Employee;
import com.cb.repo.EmployeeRepo;
import com.cb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public String saveEmployee(Employee employee) {
        double hra = employee.getSalary()* (12.0/100);
        double ta = employee.getSalary()* (12.0/100);
        employee.setHra(hra);
        employee.setTa(ta);
        employee=repo.save(employee);
        return "Employee " + employee.getId() + " created !!!";
    }

    @Override
    public String updateEmployee(Employee employee) {
        if (repo.existsById(employee.getId()) && employee.getId() != null){
            double hra = employee.getSalary() * (12.0/100);
            double ta = employee.getSalary() * (12.0/100);
            employee.setHra(hra);
            employee.setTa(ta);
            repo.save(employee);
        }
        return "Updated "+employee.getId()+" Successfully !!!";
    }

    @Override
    public String deleteEmployee(Integer id) {
        repo.deleteById(id);
        return "Employee "+id+" Deleted Successfully !!!";
    }

    @Override
    public Employee getOneEmployee(Integer id) {
        Optional<Employee> opt = repo.findById(id);
        return opt.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
}

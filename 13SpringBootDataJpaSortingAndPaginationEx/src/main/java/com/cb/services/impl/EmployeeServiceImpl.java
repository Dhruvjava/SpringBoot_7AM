package com.cb.services.impl;

import com.cb.entity.Employee;
import com.cb.repo.EmployeeRepo;
import com.cb.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String saveEmployees(List<Employee> employee) {
        try {
            if (employee.isEmpty()) {
                return "There is no record to save !!!";
            }
            employeeRepo.saveAll(employee);
            return "Employees saved !!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Employees Not Saved, faced some issues with saving Employee !!!";
        }
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepo.findAll();
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return (List<Employee>) employeeRepo.findAll(sort);
    }

    @Override
    public List<Employee> getPageResult(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Employee> page = employeeRepo.findAll(pageable);
        System.out.println("first "+page.isFirst());
        System.out.println("Last "+page.isLast());
        System.out.println("Empty "+page.isEmpty());
        System.out.println("next "+page.hasNext());
        System.out.println("previous "+page.hasPrevious());
        System.out.println("Total Pages "+page.getTotalPages());
        System.out.println("Total Elements "+page.getTotalElements());
        System.out.println("size "+page.getSize());
        System.out.println("Content "+page.hasContent());
        return page.getContent();
    }
}

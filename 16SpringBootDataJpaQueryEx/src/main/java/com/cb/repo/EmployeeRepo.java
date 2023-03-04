package com.cb.repo;

import com.cb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    // SQL: SELECT name FROM Employee; // get one col records
    @Query("SELECT e.empName FROM Employee e")
    public List<String> getAllEmployeesName();

    // SQL: SELECT name FROM Employee; // get all COL Records

//    @Query("FROM Employee")
    @Query("SELECT e FROM Employee e")
    List<Employee> getAllEmployees();

    // Select Multiple cols not all

    @Query("SELECT e.empName,e.empSal,e.empDept from Employee e")
    List<Object[]> getMultipleFields();

//    @Query("SELECT e.empName FROM Employee e WHERE e.empId=:id")
    @Query("SELECT e.empName FROM Employee e WHERE e.empId= ?0")
    Optional<String> getOneName(/*@Param("id")*/ Integer id);
}

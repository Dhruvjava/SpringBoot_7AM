package com.cb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee_tab")
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSal;

    private Department dept;
}

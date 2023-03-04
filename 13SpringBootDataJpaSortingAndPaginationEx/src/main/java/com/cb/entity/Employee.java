package com.cb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "emp_tab")
public class Employee {

    @Id
    @Column(name = "eid")
    private Integer id;

    @Column(name = "ename")
    private String name;

    @Column(name = "esal")
    private double sal;

    @Column(name = "dept")
    private String dept;
}

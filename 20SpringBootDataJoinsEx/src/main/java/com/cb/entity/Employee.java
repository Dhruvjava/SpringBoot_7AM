package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee_tab")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer empId;

    @Column(name = "name")
    private String empName;

    @Column(name = "salary")
    private Double empSal;

//    @Column(name = "dept")
    @ManyToOne
    @JoinColumn(name = "idFK")
    private Department dept;
}

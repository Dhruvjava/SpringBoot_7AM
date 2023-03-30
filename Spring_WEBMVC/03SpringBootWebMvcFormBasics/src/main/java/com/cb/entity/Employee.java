package com.cb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Employee {

    private Integer id;

    private String name;

    private Double salary;

    private String pwd;

    private String dept;

    private String addr;
}

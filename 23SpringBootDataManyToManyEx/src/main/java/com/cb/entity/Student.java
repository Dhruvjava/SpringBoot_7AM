package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student_tab")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer sId;

    @Column(name = "name")
    private String sName;

    @Column(name = "fee")
    private Double sFee;

    @ManyToMany
    @JoinTable(name = "student_course_tab", joinColumns = @JoinColumn(name = "sidFk"),
                    inverseJoinColumns = @JoinColumn(name = "cidFk"))
    private List<Course> courses;
}

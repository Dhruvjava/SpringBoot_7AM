package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "course_tab")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer cId;

    @Column(name = "code")
    private String ccode;

    @Column(name = "name")
    private String cname;
}

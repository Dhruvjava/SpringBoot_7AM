package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stud_tab")
public class Student {

    @Id
    @Column(name = "sid")
//    @GeneratedValue(strategy = GenerationType.AUTO) // this one will ask to db that which pk db is support
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) // it is generally used in Oracle type of db
//    @GeneratedValue(strategy = GenerationType.TABLE) // it will create a temp table to store next pk val
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL (it is called auto increament)
    private Integer id;

    @Column(name = "sname")
    private String name;

    @Column(name = "sfees")
    private Double fees;

    @Column(name = "sdoj")
    @Temporal(TemporalType.DATE) // Stores Date only
//    @Temporal(TemporalType.TIME) // Stores Time Only
//    @Temporal(TemporalType.TIMESTAMP) // Stores Date And Time If we'll not specify the This is the default
    private Date doj;
}

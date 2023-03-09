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
@Table(name = "product_tab")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer pid;

    @Column(name = "code")
    private String pcode;

    @OneToMany
    @JoinColumn(name = "mIdFK")
    private List<Model> model;
}

package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="prod_tab")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer pId;

    @Column(name = "name")
    private String pName;

    @Column(name = "cost")
    private Double pCost;

    @ManyToOne
    @JoinColumn(name = "vIdFK")
    private Vendor vendor;

}

package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_tab_dhruv")
public class Product {

    @Id
    @GeneratedValue(generator = "test")
    @GenericGenerator(name = "test", strategy = "com.cb.gen.MyCustomGenerator")
    @Column(name = "id")
    private String pid;

    @Column(name = "code"/*, unique = true,
                    nullable = false, updatable = false,
                    insertable = true, length = 50*/)
    private String pcode;

    @Column(name = "name")
    private String pname;

}

package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book_tab")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "cost")
    private Double bookCost;

    @Column(name = "type")
    private String bookType;
}

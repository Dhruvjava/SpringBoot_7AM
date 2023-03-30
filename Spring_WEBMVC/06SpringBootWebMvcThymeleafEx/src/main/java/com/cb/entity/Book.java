package com.cb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private Double bookCost;
}

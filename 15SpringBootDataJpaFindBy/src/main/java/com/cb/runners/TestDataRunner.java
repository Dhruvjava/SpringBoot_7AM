package com.cb.runners;

import com.cb.entity.Book;
import com.cb.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestDataRunner implements CommandLineRunner {

    @Autowired
    private BookRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.saveAll(Arrays.asList(new Book(null, "java", "dhruv", 4000.0, "IT"),
                        new Book(null, "Spring", "dhruv", 8000.0, "SD"),
                        new Book(null, "Spring Boot", "dhruv", 18000.0, "SBD"),
                        new Book(null, "Microservices", "dhruv", 36000.0, "MSD")));
        System.out.println("---- Record Saved ----");

        //        repo.findByAuthor("dhruv").forEach(System.out::println);
        //
        //        System.out.println("---- Retrieve Data by cost ----");
        //        repo.findByBookCostGreaterThanEqual(8000D).forEach(System.out::println);
        //        System.out.println("---- Retrieve Data by bookType ----");
        //
        //        repo.findByBookType("SBD").forEach(System.out::println);
        //
        //        System.out.println("---- get first row by Bookname Asc ----");
        //
        //        System.out.println(repo.findFirstByOrderByBookNameAsc());
        //
        //        System.out.println("---- get Top row by BookCost Desc ----");
        //
        //        System.out.println(repo.findTopByOrderByBookCostDesc());
        //
        //        System.out.println("---- get Top row by BookCost ----");
        //
        //        System.out.println(repo.findTopByOrderByBookCost());
        //
        //        System.out.println("---- get first 2 row by Book name ----");
        //
        //
        //        Sort.TypedSort<Book> per = Sort.sort(Book.class);
        //        Sort sort = per.by(Book::getBookName).ascending();
        //        repo.queryFirst2ByAuthor("dhruv", PageRequest.of(0, 3, sort)).getContent()
        //                        .forEach(System.out::println);
        //
        //        System.out.println("---- get Books by Top 3 Authors using slice ----");
        //        Sort.TypedSort<Book> book = Sort.sort(Book.class);
        //        Sort sort1 = book.by(Book::getBookName).ascending()
        //                        .and(book.by(Book::getAuthor).descending());
        //        repo.findTop3ByAuthor("dhruv", PageRequest.of(0, 3, sort1)).getContent()
        //                        .forEach(System.out::println);
        //
        //        System.out.println("---- cost not equal and author not like ----");
        //        repo.findByBookCostGreaterThanOrBookCostLessThanAndAuthorNotLike(4000D,4000D,"%k").forEach(System.out::println);

        Specification<Book> spec =
                        (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                                        root.get("bookCost"), 8000D);
        repo.findAll(spec).forEach(System.out::println);
    }
}

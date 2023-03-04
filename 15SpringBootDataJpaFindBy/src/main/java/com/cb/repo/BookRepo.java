package com.cb.repo;

import com.cb.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    // SELECT * FROM book WHERE author =?;
    //    List<Book> findByauthor(String author);
    List<Book> findByAuthor(String author); // It maintain Standards

    List<Book> findByBookCostGreaterThanEqual(Double bookCost);

    List<Book> findByBookType(String bookType);

    List<Book> findByBookTypeIs(String bookType);

    List<Book> findByBookTypeEquals(String bookType);

    Book findFirstByOrderByBookNameAsc();

    Book findTopByOrderByBookCostDesc();

    Book findTopByOrderByBookCost();

    Page<Book> queryFirst2ByAuthor(String author, Pageable pageable);

    Slice<Book> findTop3ByAuthor(String author, Pageable pageable);

    List<Book> findByBookCostGreaterThanOrBookCostLessThanAndAuthorNotLike(Double cost,
                    Double price, String pattern);

}

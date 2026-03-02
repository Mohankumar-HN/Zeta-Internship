package com.example.Spring_Rest.repository;

import com.example.Spring_Rest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByAuthor(String Author);
    List<Book> findByPriceGreaterThan(Double price);
}

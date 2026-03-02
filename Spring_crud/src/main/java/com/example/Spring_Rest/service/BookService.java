package com.example.Spring_Rest.service;

import com.example.Spring_Rest.entity.Book;
import com.example.Spring_Rest.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
     private  BookRepository repository;

    public List<Book> getAll(){
        return  repository.findAll();
    }

    public Book save(Book book){
        return repository.save(book);
    }


    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }
}

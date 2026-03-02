package com.example.Spring_Rest.controller;

import com.example.Spring_Rest.entity.Book;
import com.example.Spring_Rest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private  BookService service;

    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return  service.save(book);
    }

    @GetMapping("/author/{name}")
    public List<Book> byAuthor(@PathVariable String name){
        return service.findByAuthor(name);
    }



}

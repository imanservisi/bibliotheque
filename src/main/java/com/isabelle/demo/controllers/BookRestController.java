package com.isabelle.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isabelle.demo.entities.Book;
import com.isabelle.demo.service.BookService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookRestController {
    @Autowired
    BookService bookService;

    @RequestMapping(method=RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
}

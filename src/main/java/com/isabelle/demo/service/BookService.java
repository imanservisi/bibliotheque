package com.isabelle.demo.service;

import java.util.List;

import com.isabelle.demo.entities.Book;

public interface BookService {

    Book saveBook(Book b);
    Book updateBook(Book b);
    void deleteBook(Book b);
    void deleteBookById(Long id);
    Book getBook(Long id);
    List<Book> getAllBooks();
    List<Book> findByNameBook(String name);
    List<Book> findByNameBookContains(String name);
    List<Book> findAllByOrderByNameAsc();
}

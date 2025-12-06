package com.isabelle.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabelle.demo.entities.Book;
import com.isabelle.demo.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public void deleteBook(Book b) {
        bookRepository.delete(b);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public List<Book> findByNameContains(String name) {
        return bookRepository.findByNameContains(name);
    }

    @Override
    public List<Book> findAllByOrderByNameAsc() {
        return bookRepository.findAllByOrderByNameAsc();
    }
}

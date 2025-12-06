package com.isabelle.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isabelle.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findAllByOrderByNameAsc();
    List<Book> findByNameBook(String name);
    List<Book> findByNameBookContains(String name);
}

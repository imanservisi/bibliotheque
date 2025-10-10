package com.isabelle.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isabelle.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

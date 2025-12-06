package com.isabelle.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isabelle.demo.entities.Book;

@RepositoryRestResource(path= "rest")
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findAllByOrderByNameAsc();
    List<Book> findByName(String name);
    List<Book> findByNameContains(String name);
}

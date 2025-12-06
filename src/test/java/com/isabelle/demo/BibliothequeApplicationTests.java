package com.isabelle.demo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isabelle.demo.entities.Book;
import com.isabelle.demo.repositories.BookRepository;

@SpringBootTest
class BibliothequeApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testCreateBook() {
		Book bd = new Book("Akira", 2, LocalDateTime.now());
		bookRepository.save(bd);
	}

	@Test
	public void testUpdateBook() {
		Book bd = bookRepository.findById(5L).get();
		bd.setVolume(4);
		bookRepository.save(bd);
	}

	@Test
	public void testDeleteBook() {
		bookRepository.deleteById(5L);
	}

	@Test
	void contextLoads() {
	}

}

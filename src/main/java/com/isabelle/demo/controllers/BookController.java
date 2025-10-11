package com.isabelle.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isabelle.demo.entities.Book;
import com.isabelle.demo.repositories.BookRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public String index(Model model) {
		List<Book> books = bookRepository.findAllByOrderByNameAsc();
		model.addAttribute("books", books);
		model.addAttribute("book", new Book()); // Ajout de l'objet book pour le formulaire
		model.addAttribute("message", "bonjour biblio");
		
		return "index";
	}

	@PostMapping
	public String createBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Book> books = bookRepository.findAll();
			model.addAttribute("books", books);

			return "index";
		} else {
			book.setDateCreation(LocalDateTime.now());
			bookRepository.save(book);

			return "redirect:/";
		}
	}

	@GetMapping("/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
		Book book = bookRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Livre non trouvé"));
		model.addAttribute("book", book);

		return "update";
	}
	

	@PostMapping("/{id}")
	public String updateBook(
		@PathVariable Long id,
		@Valid @ModelAttribute Book book,
		BindingResult bindingResult,
		Model model
	) {
		if (bindingResult.hasErrors()) {
			List<Book> books = bookRepository.findAll();
			model.addAttribute("books", books);

			return "index";
		}
		
		Book existingBook = bookRepository.findById(book.getId())
			.orElseThrow(() -> new RuntimeException("Livre non trouvé"));
			
		existingBook.setName(book.getName());
		existingBook.setVolume(book.getVolume());
		
		bookRepository.save(existingBook);
		
		return "redirect:/";
	}

	@PostMapping("/{id}/delete")
	public String deleteBook(@PathVariable Long id) {
		Book book = bookRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Livre non trouvé"));
		bookRepository.delete(book);
		
		return "redirect:/";
	}
	
	
}

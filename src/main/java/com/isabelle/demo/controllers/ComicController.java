package com.isabelle.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ComicController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("message", "bonjour biblio");
		
		return "index";
	}
}

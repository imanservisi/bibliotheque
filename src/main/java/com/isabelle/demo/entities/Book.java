package com.isabelle.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Le nom ne peut pas être vide")
	private String name;
	
	@PositiveOrZero(message = "Le numéro de volume ne peut pas être négatif")
	private Integer volume;
	
	private LocalDateTime dateCreation;

	public Book() {
		super();
	}

	public Book(String name, Integer volume, LocalDateTime dateCreation) {
		super();
		this.name = name;
		this.volume = volume;
		this.dateCreation = dateCreation;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getVolume() {
		return volume;
	}
	
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "{" +
			"name='" + name + "'" +
			", volume='" + volume + "'" +
			", dateCreation='" + dateCreation + "'" +
			"}";
	}	
}

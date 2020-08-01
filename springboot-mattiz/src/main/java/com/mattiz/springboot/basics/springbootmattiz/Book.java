package com.mattiz.springboot.basics.springbootmattiz;

import javax.validation.constraints.Size;

public class Book {
	Long Id;
	@Size(min=2, max=150, message="Title length not correct.")
	String title;
	String author;
	
	public Book() {
	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", author=" + author + "]";
	}

}

package com.mattiz.persistence.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BOOKS")
public class Book implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	@Id
	@Column(name = "ISBN_CODE")
	private String isbn;

	@Column(name = "BOOK_TITLE")
	private String title;

	public Book() {
	}

	public Book(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

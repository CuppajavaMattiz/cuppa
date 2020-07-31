package com.mattiz.beans;

public class AuthorDTO {

	private String isbnCode;

	private String author;
	
	public AuthorDTO(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

}

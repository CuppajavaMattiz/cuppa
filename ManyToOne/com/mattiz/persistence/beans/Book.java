package com.mattiz.persistence.beans;

import java.util.Set;

public class Book {

	private String isbnCode;
	
	private String title;
	
	private Set authors;

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public Set getAuthors() {
		return authors;
	}

	public void setAuthors(Set authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}

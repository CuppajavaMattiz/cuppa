package com.mattiz.persistence.beans;

public class Authors {
	String author;

	String isbn_Code;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the isbn_Code
	 */
	public String getIsbn_Code() {
		return isbn_Code;
	}

	/**
	 * @param isbn_Code
	 *            the isbn_Code to set
	 */
	public void setIsbn_Code(String isbn_Code) {
		this.isbn_Code = isbn_Code;
	}

}

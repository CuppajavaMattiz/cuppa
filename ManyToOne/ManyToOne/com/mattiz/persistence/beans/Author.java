package com.mattiz.persistence.beans;

public class Author {
	
	public Author(){		
	}
	
	public Author(String first, String last){
		this.firstName = first;
		this.lastName= last;
	}
	
	private String firstName;

	private String lastName;
	
	private long id;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

package com.mattiz.stream;

public class PersonDTO {

	private String firstName;

	public PersonDTO(String firstName) {
		super();
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static PersonDTO myMap(Person person) {
		return new PersonDTO(person.getFirstName());
	}

}

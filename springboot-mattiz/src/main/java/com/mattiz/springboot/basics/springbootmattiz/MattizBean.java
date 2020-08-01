package com.mattiz.springboot.basics.springbootmattiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//static filtering

@JsonIgnoreProperties(value= {"firstName"})
public class MattizBean {

	String firstName;
	
	String lastName;
	
	@JsonIgnore
	String secure;

	public MattizBean(String val1, String val2, String val3) {
		super();
		this.firstName = val1;
		this.lastName = val2;
		this.secure = val3;
	}

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

	public String getSecure() {
		return secure;
	}

	public void setSecure(String secure) {
		this.secure = secure;
	}

}

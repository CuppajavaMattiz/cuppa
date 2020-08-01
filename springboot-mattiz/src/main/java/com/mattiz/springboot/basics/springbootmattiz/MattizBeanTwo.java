package com.mattiz.springboot.basics.springbootmattiz;

import com.fasterxml.jackson.annotation.JsonFilter;

//dynamic filtering

@JsonFilter("MattizBeanFilter")
public class MattizBeanTwo {

	String firstName;
	
	String lastName;
	
	String secure;

	public MattizBeanTwo(String val1, String val2, String val3) {
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

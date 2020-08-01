package com.mattiz.springboot.basics.springbootmattiz;

import java.util.Date;

public class ExceptionStructure {
	public Date timestamp;
	public String message;
	public String details;
	
	public ExceptionStructure(Date date, String message, String details) {
		super();
		this.timestamp = date;
		this.message = message;
		this.details = details;
	}

	
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
}

package com.mattiz.persistence.data;

import org.springframework.dao.DataAccessException;

import com.mattiz.service.spring.AuthorsBean;

public interface IAuthorLookupBean {

	public AuthorsBean lookupIsbn(String isbn) throws DataAccessException;
	
	public void insertAuthor(String isbn, String authorName);
}

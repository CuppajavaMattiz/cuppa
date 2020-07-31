package com.mattiz.persistence.data;

import org.springframework.dao.DataAccessException;

import com.mattiz.persistence.beans.AuthorBean;

public interface IMattizDao {

	public AuthorBean lookupIsbn(String isbn) throws DataAccessException;

	public void insertAuthor(String isbn, String authorName)
			throws DataAccessException;

}

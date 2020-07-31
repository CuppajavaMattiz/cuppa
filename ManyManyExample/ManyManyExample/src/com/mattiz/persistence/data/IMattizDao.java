package com.mattiz.persistence.data;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.mattiz.persistence.beans.Author;
import com.mattiz.persistence.beans.Book;

public interface IMattizDao {

	public Set<Book> getBooksForAuthor(int authorId) throws DataAccessException;

	public void insertAuthor(String authorName, Set<Book> books)
			throws DataAccessException;

}
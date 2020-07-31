package com.mattiz.service.spring;

import java.util.Set;

import com.mattiz.persistence.beans.Book;
import com.mattiz.persistence.data.IMattizDao;

public interface IMattizDelegate {

	public void insertAuthor(String authorName, Set<Book> books);

	public Set<Book> getBooksForAuthor(int authorId);

	public IMattizDao getMattizDao();

	public void setMattizDao(IMattizDao mattizDao);

}
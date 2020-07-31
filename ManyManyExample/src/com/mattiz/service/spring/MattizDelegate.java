package com.mattiz.service.spring;

import java.util.Set;

import com.mattiz.persistence.beans.Book;
import com.mattiz.persistence.data.IMattizDao;

public class MattizDelegate implements IMattizDelegate {

	private IMattizDao mattizDao;

	public void insertAuthor(String authorName, Set<Book> books) {
		getMattizDao().insertAuthor(authorName, books);
	}

	public Set<Book> getBooksForAuthor(int authorId) {
		Set<Book> books = getMattizDao().getBooksForAuthor(authorId);
		return books;
	}

	public IMattizDao getMattizDao() {
		return mattizDao;
	}

	public void setMattizDao(IMattizDao mattizDao) {
		this.mattizDao = mattizDao;
	}

}
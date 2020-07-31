package com.mattiz.persistence.data;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mattiz.persistence.beans.Author;
import com.mattiz.persistence.beans.Book;


public class AuthorLookupBean {

	private HibernateTemplate hibernateTemplate;

	public void insertBook() throws DataAccessException {
		Book book = new Book();
		book.setIsbnCode("124");
		book.setTitle("The Dodo");
		book.setAuthors(new HashSet());
		book.getAuthors().add(new Author("Roy","John"));
		book.getAuthors().add(new Author("James","Joyce"));
		book.getAuthors().add(new Author("Jill","Joyce"));
		book.getAuthors().add(new Author("Amy","Watt"));
		book.getAuthors().add(new Author("Matt","Tizz"));
		HibernateTemplate template = getHibernateTemplate();
		template.save(book);
	}
	
	public void getAuthorsFromBook() throws DataAccessException {
		String isbn = "124";
		Book book = (Book)getHibernateTemplate().load(Book.class, isbn);
		Set authors = book.getAuthors();
		Iterator  iterator = authors.iterator();
		while(iterator.hasNext()){
			Author author = (Author)iterator.next();
			System.out.println("FIRST NAME "+author.getFirstName());
			System.out.println("SECOND NAME "+author.getLastName());
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

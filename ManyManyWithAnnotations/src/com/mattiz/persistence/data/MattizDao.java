package com.mattiz.persistence.data;

import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mattiz.persistence.beans.Author;
import com.mattiz.persistence.beans.Book;

public class MattizDao implements IMattizDao {

	private HibernateTemplate hibernateTemplate;

	public Set<Book> getBooksForAuthor(int authorId) throws DataAccessException {
		Author authorBean = null;
		
		HibernateTemplate template = getHibernateTemplate();
		authorBean = (Author)template.get(Author.class,
				authorId);		
		System.out.println(authorBean.getName()+"\n");
		
		Set<Book> books = authorBean.getBooks();
		for(Book b: books){
			System.out.println(b.getTitle());
		}	
		template.flush();
		template.clear();
		
		return books;
	}
	

	public void insertAuthor(String authorName, Set<Book> books)
			throws DataAccessException {
		Author authorBean = new Author();
		authorBean.setBooks(books);		
		authorBean.setName(authorName);
		HibernateTemplate template = getHibernateTemplate();
		template.saveOrUpdate(authorBean);
		System.out.println("Inserted/Updated AuthorBean "
				+ authorBean.getName());
		template.flush();
		template.clear();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
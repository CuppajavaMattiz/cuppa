package com.mattiz.persistence.data;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mattiz.persistence.beans.Authors;
import com.mattiz.service.spring.AuthorsBean;

public class AuthorLookupBean extends HibernateDaoSupport {

	public AuthorsBean lookupIsbn(String isbn) throws DataAccessException {
		// List l = getHibernateTemplate().find(
		// "from Authors author where author.isbnCode = ?", isbn);//use when
		// isbn is not PK
		Authors author = null;
		author = (Authors) getHibernateTemplate().load(Authors.class, isbn);
		AuthorsBean authorsBean = new AuthorsBean();
		authorsBean.setAuthor(author.getAuthor());
		authorsBean.setIsbnCode(author.getIsbn_Code());
		return authorsBean;
	}

	public void insertAuthor(String isbn, String authorName)
			throws DataAccessException {
		Authors authors = new Authors();
		authors.setAuthor(authorName);
		authors.setIsbn_Code(isbn);
		getHibernateTemplate().saveOrUpdate(authors);
	}

}

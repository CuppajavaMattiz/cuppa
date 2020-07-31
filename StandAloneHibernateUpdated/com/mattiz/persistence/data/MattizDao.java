package com.mattiz.persistence.data;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mattiz.persistence.beans.AuthorBean;

public class MattizDao implements IMattizDao {

	private HibernateTemplate hibernateTemplate;

	public AuthorBean lookupIsbn(String isbn) throws DataAccessException {
		// List l = getHibernateTemplate().find(
		// "from Authors authorBean where authorBean.isbnCode = ?", isbn);//use
		// when
		// isbn is not PK
		AuthorBean authorBean = null;
		authorBean = (AuthorBean) getHibernateTemplate().load(AuthorBean.class,
				isbn);
		return authorBean;
	}

	public void insertAuthor(String isbn, String authorName)
			throws DataAccessException {
		AuthorBean authorBean = new AuthorBean();
		authorBean.setAuthor(authorName);
		authorBean.setIsbnCode(isbn);
		HibernateTemplate template = getHibernateTemplate();
		template.saveOrUpdate(authorBean);
		System.out.println("Inserted/Updated AuthorBean, ISBN "
				+ authorBean.getAuthor() + " " + authorBean.getIsbnCode());
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

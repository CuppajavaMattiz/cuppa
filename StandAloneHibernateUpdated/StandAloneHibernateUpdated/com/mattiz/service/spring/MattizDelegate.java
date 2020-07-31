package com.mattiz.service.spring;

import com.mattiz.persistence.beans.AuthorBean;
import com.mattiz.persistence.data.IMattizDao;

public class MattizDelegate implements IMattizDelegate {

	private IMattizDao mattizDao;

	public void addAuthor(String isbnCode, String author) {
		getMattizDao().insertAuthor(isbnCode, author);
	}

	public AuthorBean findAuthor(String isbnCode) {
		AuthorBean authorsBean = getMattizDao().lookupIsbn(isbnCode);
		return authorsBean;
	}
	
	public IMattizDao getMattizDao() {
		return mattizDao;
	}

	public void setMattizDao(IMattizDao mattizDao) {
		this.mattizDao = mattizDao;
	}

}

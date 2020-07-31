package com.mattiz.service.spring;

import com.mattiz.persistence.beans.AuthorBean;
import com.mattiz.persistence.data.IMattizDao;

public interface IMattizDelegate {

	
	public void addAuthor(String isbnCode, String author);

	public AuthorBean findAuthor(String isbnCode);
	
	public IMattizDao getMattizDao();

	public void setMattizDao(IMattizDao mattizDao);

}

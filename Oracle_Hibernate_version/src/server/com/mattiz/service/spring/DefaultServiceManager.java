package com.mattiz.service.spring;

import com.mattiz.persistence.data.AuthorLookupBean;
import com.mattiz.service.spring.AuthorsBean;

/**
 * @author mattyj
 * 
 */
public class DefaultServiceManager implements ServiceManager {
	private AuthorLookupBean authorLookup;

	public void addAuthor(String isbnCode, String author) {
		authorLookup.insertAuthor(isbnCode, author);
	}

	public AuthorsBean findAuthor(String isbnCode) {

		AuthorsBean authorsBean = authorLookup.lookupIsbn(isbnCode);
		return authorsBean;
	}

	public AuthorLookupBean getAuthorLookup() {
		return authorLookup;
	}

	public void setAuthorLookup(AuthorLookupBean authorsLookup) {
		this.authorLookup = authorsLookup;
	}

}

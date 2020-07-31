package com.mattiz.service.spring;

import com.mattiz.persistence.data.AuthorLookupBean;

public class DefaultServiceManager implements ServiceManager {
	
	private AuthorLookupBean authorLookup;

	public void insertBook(){
		authorLookup.insertBook();
		authorLookup.getAuthorsFromBook();
	}

	public AuthorLookupBean getAuthorLookup() {
		return authorLookup;
	}

	public void setAuthorLookup(AuthorLookupBean authorsLookup) {
		this.authorLookup = authorsLookup;
	}
}

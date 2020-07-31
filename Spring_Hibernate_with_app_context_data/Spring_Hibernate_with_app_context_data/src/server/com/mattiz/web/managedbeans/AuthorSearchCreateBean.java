package com.mattiz.web.managedbeans;

import com.mattiz.persistence.data.AuthorLookupBean;
import com.mattiz.service.spring.AuthorsBean;
import com.mattiz.service.spring.ServiceManager;
/**
 * 
 * @author mattyj
 *
 */
public class AuthorSearchCreateBean {

	private String isbnCode;

	private String author;

	private AuthorsBean authorsBean;

	private ServiceManager serviceManager;
	
	/**
	 * 
	 */
	private AuthorLookupBean authorLookup;

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String addAuthor() {
		serviceManager.addAuthor(isbnCode, author);
		System.out.println("Return from AuthorsSearchCreateBean:: add Author");
		return "two";
	}

	public String findAuthor() {
		authorsBean = serviceManager.findAuthor(isbnCode);
		isbnCode = authorsBean.getIsbnCode();
		author = authorsBean.getAuthor();
		System.out.println("Return from AuthorsSearchCreateBean:: find Author");
		return "one";
	}

	public AuthorsBean getAuthorsBean() {
		return authorsBean;
	}

	public void setAuthorsBean(AuthorsBean authorsBean) {
		this.authorsBean = authorsBean;
	}

	/**
	 * @return the authorLookup
	 */
	public AuthorLookupBean getAuthorLookup() {
		return authorLookup;
	}

	/**
	 * @param authorLookup the authorLookup to set
	 */
	public void setAuthorLookup(AuthorLookupBean authorLookup) {
		this.authorLookup = authorLookup;
	}
}

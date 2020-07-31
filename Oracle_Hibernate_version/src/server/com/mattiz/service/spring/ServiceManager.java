package com.mattiz.service.spring;
/**
 * 
 * 
 * @author mattyj
 *
 */

public interface ServiceManager {

	public void addAuthor(String isbnCode, String author);
	
	public AuthorsBean findAuthor(String isbnCode);
}

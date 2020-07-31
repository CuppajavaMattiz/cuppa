package com.mattiz.web.managedbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mattiz.service.spring.AuthorsBean;
import com.mattiz.service.spring.DefaultServiceManager;
import com.mattiz.service.spring.ServiceManager;

public class AuthorSearchCreateBean {

	private ApplicationContext applicationContext;

	private String isbnCode;

	private String author;

	private AuthorsBean authorsBean;

	private ServiceManager serviceManager;

	public ServiceManager getServiceManager() {
		serviceManager = (DefaultServiceManager) applicationContext
				.getBean("mattiz.service.manager");
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

	public void insertBook() {
		serviceManager = getServiceManager();
		serviceManager.insertBook();
	}

	public AuthorsBean getAuthorsBean() {
		return authorsBean;
	}

	public void setAuthorsBean(AuthorsBean authorsBean) {
		this.authorsBean = authorsBean;
	}

	public static void main(String[] args) {
		AuthorSearchCreateBean authorSearchCreateBean = new AuthorSearchCreateBean();
		authorSearchCreateBean.applicationContext = new ClassPathXmlApplicationContext(
				"resources/mattiz.xml");
		authorSearchCreateBean.isbnCode = "786";
		authorSearchCreateBean.author = "Mark";
		authorSearchCreateBean.insertBook();
	}
}

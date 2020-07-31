package com.mattiz.web.managedbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mattiz.persistence.beans.AuthorBean;
import com.mattiz.service.spring.IMattizDelegate;

public class MattizMain {

	private ApplicationContext applicationContext;

	private IMattizDelegate mattizDelegate;

	public IMattizDelegate getMattizDelegate() {
		mattizDelegate = (IMattizDelegate) applicationContext
				.getBean("mattiz.service.delegate");
		return mattizDelegate;
	}

	public void setMattizDelegate(IMattizDelegate mattizDelegate) {
		this.mattizDelegate = mattizDelegate;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		MattizMain mattizMain = new MattizMain();
		mattizMain.applicationContext = new ClassPathXmlApplicationContext(
				"resources/mattiz.xml");
		mattizMain.getMattizDelegate().addAuthor("007", "Bond");
		AuthorBean authorBean = mattizMain.getMattizDelegate().findAuthor("007");
		System.out.println("AUTHOR IS " + authorBean.getAuthor());
	}

}

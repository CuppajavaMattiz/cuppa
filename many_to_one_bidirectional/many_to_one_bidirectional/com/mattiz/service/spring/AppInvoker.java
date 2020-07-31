package com.mattiz.service.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mattiz.persistence.data.MappingDAO;
import com.mattiz.persistence.data.MappingDAOImpl;

public class AppInvoker {

	private ApplicationContext applicationContext;

	private MappingDAO mappingDAOImpl;

	public static void main(String[] args) {
		AppInvoker appInvoker = new AppInvoker();
		appInvoker.setApplicationContext(new ClassPathXmlApplicationContext(
				"resources/mattiz.xml"));
		appInvoker.getMappingDAO().initializeDB();
		appInvoker.getMappingDAO().getContributingAuthors(2L);
		appInvoker.getMappingDAO().getBookForAuthor(11);
	}

	public MappingDAO getMappingDAO() {
		mappingDAOImpl = (MappingDAOImpl) applicationContext
				.getBean("mattiz.mattizDAO");
		return mappingDAOImpl;
	}

	public void setMapppingDAO(MappingDAO mappingDAOImpl) {
		this.mappingDAOImpl = mappingDAOImpl;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}

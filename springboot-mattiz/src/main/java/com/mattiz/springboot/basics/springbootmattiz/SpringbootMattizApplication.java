package com.mattiz.springboot.basics.springbootmattiz;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringbootMattizApplication {



	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootMattizApplication.class, args);
		for (String str : ctx.getBeanDefinitionNames()) {
			System.out.println(str);
		}
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver locale = new AcceptHeaderLocaleResolver();
		//SessionLocaleResolver locale = new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}

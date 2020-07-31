package com.mattiz.web.managedbeans;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mattiz.persistence.beans.Book;
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
		Book a = new Book("1e","The Cool Drink");
		Book b = new Book("1a","Lost Island");
		Book c = new Book("1b","Treasure Hunt");
		Book d = new Book("1c","Down With Fever");
		Book e = new Book("1d","Imagination runs Wild");
		Book f = new Book("1r","The Wild West");
		Book g = new Book("1h","Gregorios");
		Book h = new Book("14","Mar Thoma");
		Book i = new Book("15","Christ and the Disciples");
		Book j = new Book("1t","Long live His Cotton Socks");
		Book k = new Book("19","Praise Be to Harman!");
		Set<Book> aa = new HashSet<Book>();
		aa.add(a);
		aa.add(b);
		aa.add(c);		
		aa.add(d);
		aa.add(e);
		aa.add(f);
		aa.add(g);
		Set<Book> ab = new HashSet<Book>();
		ab.add(a);		
		ab.add(b);
		ab.add(h);
		Set<Book> ac = new HashSet<Book>();
		ac.add(i);
		ac.add(j);		
		ac.add(k);
		Set<Book> ad = new HashSet<Book>();
		ad.add(a);		
		ad.add(k);	
		Set<Book> af = new HashSet<Book>();
		af.add(a);
		Set<Book> ag = new HashSet<Book>();
		ag.add(a);	
		Set<Book> ah = new HashSet<Book>();
		ah.add(e);	
		Set<Book> aj = new HashSet<Book>();
		aj.add(f);	
		mattizMain.getMattizDelegate().insertAuthor("Mac",aa);
		mattizMain.getMattizDelegate().insertAuthor("Kenzie", ab);
		mattizMain.getMattizDelegate().insertAuthor("John",ac);		
		mattizMain.getMattizDelegate().insertAuthor("Warbler",ad);
		mattizMain.getMattizDelegate().insertAuthor("Huan",af);
		mattizMain.getMattizDelegate().insertAuthor("Mike",ag);
		mattizMain.getMattizDelegate().insertAuthor("Don",ag);		
		mattizMain.getMattizDelegate().insertAuthor("John",ah);
		mattizMain.getMattizDelegate().insertAuthor("Mark",aj);
		mattizMain.getMattizDelegate().insertAuthor("Jim",ah);
		mattizMain.getMattizDelegate().insertAuthor("Joe",ah);
		mattizMain.getMattizDelegate().insertAuthor("Harry",ad);		
		mattizMain.getMattizDelegate().insertAuthor("Noman",ag);
		mattizMain.getMattizDelegate().insertAuthor("Julian",aj);
		mattizMain.getMattizDelegate().insertAuthor("Tick",af);
		mattizMain.getMattizDelegate().insertAuthor("Toe",ac);
		mattizMain.getMattizDelegate().getBooksForAuthor(1);
		System.out.println("----------------------");
		mattizMain.getMattizDelegate().getBooksForAuthor(5);
	}

}
package com.mattiz.persistence.data;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mattiz.persistence.beans.BookWithMultipleAuthors;
import com.mattiz.persistence.beans.ContributingAuthor;

public class MappingDAOImpl implements MappingDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Set<ContributingAuthor> getContributingAuthors(long isbnCode) {
		BookWithMultipleAuthors bookWithMultipleAuthors = (BookWithMultipleAuthors) getHibernateTemplate()
				.load(BookWithMultipleAuthors.class, isbnCode);
		Set<ContributingAuthor> authors = bookWithMultipleAuthors
				.getContributingAuthors();
		Iterator<ContributingAuthor> i = authors.iterator();
		while (i.hasNext()) {
			System.out.println("Author "
					+ ((ContributingAuthor) i.next()).getFirstName());
		}
		return authors;
	}

	public BookWithMultipleAuthors getBookForAuthor(long authorId) {
		ContributingAuthor contributingAuthor = (ContributingAuthor) getHibernateTemplate()
				.load(ContributingAuthor.class, authorId);
		BookWithMultipleAuthors book = contributingAuthor
				.getBookContributedToByAuthor();
		System.out.println("BOOK " + book.getTitle());
		return book;
	}

	public void initializeDB() {//fill  up db with random named AUTHORs and BOOKs
		HibernateTemplate template = getHibernateTemplate();
		BookWithMultipleAuthors bookEntity = new BookWithMultipleAuthors();
		Random random = new Random();
		int ran = generateRandomInteger(65, 74, random);//boiler plate code
		bookEntity.setTitle(new String(new char[] { (char) ran,
				(char) (ran + 3), (char) (ran + 10), (char) (ran + 15) }));
		template.saveOrUpdate(bookEntity);
		System.out.println("Inserted Book, ISBN, Title:  "
				+ bookEntity.getIsbnCode() + " " + bookEntity.getTitle());
		for (int i = 0; i < 10; i++) {
			ran = generateRandomInteger(65, 85, random);
			ContributingAuthor contributingAuthor = newContributingAuthor(ran,
					bookEntity);
			System.out.println("Inserted Author, First and last name:  "
					+ contributingAuthor.getFirstName() + " "
					+ contributingAuthor.getLastName());
		}
	}

	private ContributingAuthor newContributingAuthor(int i,
			BookWithMultipleAuthors bookEntity) {
		HibernateTemplate template = getHibernateTemplate();
		ContributingAuthor contributingAuthor = new ContributingAuthor();
		contributingAuthor.setBookId(i);
		contributingAuthor.setFirstName(new String(new char[] { (char) (i + 2),
				(char) (i + 1), (char) (i + 3) }));
		contributingAuthor.setLastName(new String(new char[] { (char) (i + 3),
				(char) (i + 2), (char) (i + 4) }));
		contributingAuthor.setBookContributedToByAuthor(bookEntity);
		template.save(contributingAuthor);
		return contributingAuthor;
	}

	private static int generateRandomInteger(int aStart, int aEnd,
			Random aRandom) {//boiler plate code to generate ascii code for A-Z
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
    	long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

}

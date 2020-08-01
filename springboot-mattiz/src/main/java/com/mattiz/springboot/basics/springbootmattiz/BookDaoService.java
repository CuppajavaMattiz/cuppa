package com.mattiz.springboot.basics.springbootmattiz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BookDaoService {

	static List<Book> bookList = new ArrayList<Book>();
	static long bookCount = 1;
	
	static {
		Book book1 = new Book("Tintin in India", "Cuppajava");
		Book book2 = new Book("Tintin in Mexico", "Cuppa");
		Book book3 = new Book("Tintin in Guatemala", "Java");
		Book book4 = new Book("Tintin in Lisbon", "Zorro");
		Book book5 = new Book("Tintin in Accra", "Xorro");
		Book book6 = new Book("Tintin in Zambia", "Xania");
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		bookList.add(book6);
		for(Book book: bookList) {
			if(book.getId()==null) {
				book.setId(bookCount++);
			}
		}
	}
	public List<Book> getAllBooks() {
		return bookList;
	}
	
	public Book addBook(Book book) {
		book.setId(bookCount++);
		bookList.add(book);
		return book;
	}
	
	public Book getBook(Long Id) {
		for(Book book: bookList) {
			if(book.getId().equals(Id)) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not found "+Id );
	}
	
	public Book deleteBookById(Long Id) {
		for(Book book: bookList) {
			if(book.getId().equals(Id)) {
				bookList.remove(book);
				return book;
			}
	   }
		throw new BookNotFoundException("Book not found "+Id );
	}
}

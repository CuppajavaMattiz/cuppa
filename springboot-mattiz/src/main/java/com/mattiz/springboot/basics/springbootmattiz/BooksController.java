package com.mattiz.springboot.basics.springbootmattiz;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class BooksController {

	@Autowired
	private BookDaoService bookDaoService;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path="/books")
	public List<Book> getBooks() {
		Book book = new Book("Tintin in Arabia", "Mattiz");
		List<Book> arr = new ArrayList<Book>();
		arr.add(book);
		return arr;
	}

	@GetMapping(path="/books/list")
	public List<EntityModel> getAllBooks() {
		List<Book> booksList = bookDaoService.getAllBooks();
		List<EntityModel> modelList = new ArrayList<EntityModel>();
		for(Book bk: booksList) {
			EntityModel<Book> model = new EntityModel<Book>(bk);
			Long id = bk.getId();
			WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getBook(id));
			model.add(linkTo.withRel("get-book"));
			modelList.add(model);
		}
		return modelList;
	}

	@PostMapping(path="/books/add")
	public ResponseEntity<Object> addBook(@Valid @RequestBody Book book) {
		Book returnedBook = bookDaoService.addBook(book);
		bookDaoService.getAllBooks();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/books/{Id}").buildAndExpand(returnedBook.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/books/{Id}")
	public EntityModel<Book> getBook(@PathVariable Long Id) {
		Book book  = bookDaoService.getBook(Id);
		EntityModel<Book> model = new EntityModel<Book>(book);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllBooks());
		model.add(linkTo.withRel("all-books"));
		return model;
	}
	
	@DeleteMapping(path="/books/remove/{Id}")
	public ResponseEntity<Object> deleteBookById(@PathVariable Long Id) {
		Book book = bookDaoService.deleteBookById(Id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/books/{Id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.accepted().build();
	}
	
//	@GetMapping(path="/hello-world/internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}
	
	@GetMapping(path="/hello-world/internationalized/again")
	public String helloWorldInternationalizedAgain() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
   
}

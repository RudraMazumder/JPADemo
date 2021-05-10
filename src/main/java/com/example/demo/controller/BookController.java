package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService booksService;

	@GetMapping
	private List<Book> getAllBooks(@RequestParam(name = "authorName",required = false) String authorName,
			@RequestParam(name = "pricemorethan", required = false) Integer price) {
		
		if(!ObjectUtils.isEmpty(authorName) && !ObjectUtils.isEmpty(price))
			return booksService.findByAuthorAndPriceGreaterThan(authorName, price);
		else if(!ObjectUtils.isEmpty(authorName) && ObjectUtils.isEmpty(price))
			return booksService.findByAuthor(authorName);
		else
			return booksService.getAll();
	}
	
	
	@GetMapping("/{id}")
	private Book getBookById(@PathVariable(name = "id") Integer id) {
		return booksService.getBookById(id);
		
	}
	
	@PostMapping
	private void insertBook(@RequestBody Book book) {
		booksService.saveBook(book);
	}
	
	@DeleteMapping("/{id}")
	private Integer deleteBook(@PathVariable(name = "id") Integer id){
		return booksService.deleteBookById(id);
	}
	
	@PutMapping
	private void updateBook(@RequestBody Book book) {
		booksService.saveBook(book);
	}

}

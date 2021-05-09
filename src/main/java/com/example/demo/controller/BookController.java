package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService booksService;

	@GetMapping("/books")
	private List<Book> getAllBooks() {
		return booksService.getAll();
	}
	
	@GetMapping("/books/{id}")
	private Book getBookById(@PathVariable(name = "id") Integer id) {
		return booksService.getBookById(id);
		
	}
	
	@PostMapping("/books")
	private void upsertBook(@RequestBody Book book) {
		booksService.saveBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	private Integer deleteBook(@PathVariable(name = "id") Integer id){
		return booksService.deleteBookById(id);
	}

}

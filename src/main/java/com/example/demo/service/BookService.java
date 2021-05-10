package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAll() {
		return bookRepository.findAll();

	}

	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public Integer deleteBookById(Integer id) {
		bookRepository.deleteById(id);
		return id;
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> findByAuthor(String authorName){
		return bookRepository.findByAuthor(authorName);
	}
	
	public List<Book> findByAuthorAndPriceGreaterThan(String authorName, Integer price){
		return bookRepository.findByAuthorAndPriceGreaterThan(authorName, price);
	}
}

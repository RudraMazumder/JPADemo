package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	public List<Book> findByAuthor(String author);
	public List<Book> findByAuthorAndPriceGreaterThan(String author,Integer price);
}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Book {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookId;

	@Column
	private String bookName;

	@Column
	private int price;

	@Column
	private String author;

}

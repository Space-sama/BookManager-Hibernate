package com.samaspace;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "book")
public class Book implements Serializable {
	
	
	
	private Integer bookId;
	private String bookTitle;
	private String bookAuthor;
	private float bookPrice;
	
	
	@Id
	@Column(name= "book_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	
	@Column(name="title", nullable = false)
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Column(name="author", nullable = false)
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	@Column(name="price", nullable = false)
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	

	
}

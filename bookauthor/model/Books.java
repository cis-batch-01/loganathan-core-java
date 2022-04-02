package com.technocis.bookauthor.model;

import java.util.Date;
import java.util.List;

public class Books {
 private String book_id;
 private  String name;
 private  String  description ;
 private  String publication;
 private Date published_date;
 private Double price;
 private List<Author> author;
public List<Author> getAuthor() {
	return author;
}
public void setAuthor(List<Author> author) {
	this.author = author;
}
public String getBook_id() {
	return book_id;
}
public void setBook_id(String book_id) {
	this.book_id = book_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public Date getPublished_date() {
	return published_date;
}
public void setPublished_date(Date published_date) {
	this.published_date = published_date;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}

public Books(String book_id, String name, String description, String publication, Date published_date, Double price,
		List<Author> author) {
	super();
	this.book_id = book_id;
	this.name = name;
	this.description = description;
	this.publication = publication;
	this.published_date = published_date;
	this.price = price;
	this.author = author;
}
public Books(String name, String description, String publication, Date published_date, Double price) {
	super();
	this.name = name;
	this.description = description;
	this.publication = publication;
	this.published_date = published_date;
	this.price = price;
}
public Books() {
	super();
	
}
@Override
public String toString() {
	return "Books \nbook_id=" + book_id + "\nname=" + name + "\ndescription=" + description + "\npublication="
			+ publication + "\npublished_date=" + published_date + "\nprice=" + price + "\nauthor=" + author + "\n";
}

 
}

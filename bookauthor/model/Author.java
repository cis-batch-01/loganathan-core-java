package com.technocis.bookauthor.model;

import java.util.Date;
import java.util.List;

public class Author {

	private  String  Author_id;
	private  String name;
	private String gender;
	private String description;
	private Date firstbook_releasedyear;
	private List<Books> book;
	public String getAuthor_id() {
		return Author_id;
	}
	public void setAuthor_id(String author_id) {
		Author_id = author_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getFirstbook_releasedyear() {
		return firstbook_releasedyear;
	}
	public void setFirstbook_releasedyear(Date firstbook_releasedyear) {
		this.firstbook_releasedyear = firstbook_releasedyear;
	}
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	public Author(String author_id, String name, String gender, String description, Date firstbook_releasedyear,
			List<Books> book) {
		super();
		Author_id = author_id;
		this.name = name;
		this.gender = gender;
		this.description = description;
		this.firstbook_releasedyear = firstbook_releasedyear;
		this.book = book;
	}
	
	
	public Author(String author_id, String name, String gender, String description, Date firstbook_releasedyear) {
		super();
		Author_id = author_id;
		this.name = name;
		this.gender = gender;
		this.description = description;
		this.firstbook_releasedyear = firstbook_releasedyear;
	}
	@Override
	public String toString() {
		return "\nAuthor_id=" + Author_id + "\nname=" + name + "\ngender=" + gender + "\ndescription="
				+ description + "\nfirstbook_releasedyear=" + firstbook_releasedyear + "\nbook=" + book + "\n";
	}
	
	
}

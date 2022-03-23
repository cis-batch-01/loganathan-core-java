package com.technocis.lmsmodel;

import java.util.Date;

public class Author {
	
	private Integer Author_id;
	private String Author_name;
	private String about;
	private String   new_book;
	private String address;
	private Date lastbook_realeasedyear;
	public Integer getAuthor_id() {
		return Author_id;
	}
	public void setAuthor_id(Integer author_id) {
		Author_id = author_id;
	}
	public String getAuthor_name() {
		return Author_name;
	}
	public void setAuthor_name(String author_name) {
		Author_name = author_name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getNew_book() {
		return new_book;
	}
	public void setNew_book(String new_book) {
		this.new_book = new_book;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getLastbook_realeasedyear() {
		return lastbook_realeasedyear;
	}
	public void setLastbook_realeasedyear(Date lastbook_realeasedyear) {
		this.lastbook_realeasedyear = lastbook_realeasedyear;
	}
	public Author(Integer author_id, String author_name, String about, String new_book, String address,
			Date lastbook_realeasedyear) {
		super();
		Author_id = author_id;
		Author_name = author_name;
		this.about = about;
		this.new_book = new_book;
		this.address = address;
		this.lastbook_realeasedyear = lastbook_realeasedyear;
	}
	public Author(String author_name, String about, String new_book, String address, Date lastbook_realeasedyear) {
		super();
		Author_name = author_name;
		this.about = about;
		this.new_book = new_book;
		this.address = address;
		this.lastbook_realeasedyear = lastbook_realeasedyear;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [Author_id=" + Author_id + ", Author_name=" + Author_name + ", about=" + about + ", new_book="
				+ new_book + ", address=" + address + ", lastbook_realeasedyear=" + lastbook_realeasedyear + "]";
	}
	
}

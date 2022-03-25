package com.technocis.library.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Author {
private  Integer id;
private  String Author_Name;
private String about;
private String newbook;
private String address;
private Date firstbook_releasedyear;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAuthor_Name() {
	return Author_Name;
}
public void setAuthor_Name(String author_Name) {
	Author_Name = author_Name;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public String getNewbook() {
	return newbook;
}
public void setNewbook(String newbook) {
	this.newbook = newbook;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getFirstbook_releasedyear() {
	return firstbook_releasedyear;
}
public void setFirstbook_releasedyear(Date firstbook_releasedyear) {
	this.firstbook_releasedyear = firstbook_releasedyear;
}
public Author(Integer id, String author_Name, String about, String newbook, String address,
		Date firstbook_releasedyear) {
	super();
	this.id = id;
	Author_Name = author_Name;
	this.about = about;
	this.newbook = newbook;
	this.address = address;
	this.firstbook_releasedyear = firstbook_releasedyear;
}
public Author(String author_Name, String about, String newbook, String address, Date firstbook_releasedyear) {
	super();
	Author_Name = author_Name;
	this.about = about;
	this.newbook = newbook;
	this.address = address;
	this.firstbook_releasedyear = firstbook_releasedyear;
}
public Author() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Author [id=" + id + ", Author_Name=" + Author_Name + ", about=" + about + ", newbook=" + newbook
			+ ", address=" + address + ", firstbook_releasedyear=" + firstbook_releasedyear + "]";
}



}

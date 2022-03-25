package com.technocis.library.model;

public class Supplier {
private Integer supplier_id;
private  String name;
private Long phone;
private  String address;
private  String  mail_Id;
private  String password;
public Integer getSupplier_id() {
	return supplier_id;
}
public void setSupplier_id(Integer supplier_id) {
	this.supplier_id = supplier_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMail_Id() {
	return mail_Id;
}
public void setMail_Id(String mail_Id) {
	this.mail_Id = mail_Id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public Supplier(Integer supplier_id, String name, Long phone, String address, String mail_Id, String password) {
	super();
	this.supplier_id = supplier_id;
	this.name = name;
	this.phone = phone;
	this.address = address;
	this.mail_Id = mail_Id;
	this.password = password;
}
public Supplier(String name, String address, Long phone, String mail_Id, String password) {
	super();
	this.name = name;
	this.phone = phone;
	this.address = address;
	this.mail_Id = mail_Id;
	this.password = password;
}
public Supplier() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Supplier [supplier_id=" + supplier_id + ", name=" + name + ", phone=" + phone + ", address=" + address
			+ ", mail_Id=" + mail_Id + ", password=" + password + "]";
}

}

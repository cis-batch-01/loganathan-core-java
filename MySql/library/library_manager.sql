create database library_manager;
use library_manager;
create table author(Author_id int primary key auto_increment ,Author_name varchar(50) not null,
about varchar(50) not null,new_book varchar(50) not null,
address varchar(50) not null,firstbook_releasedyear date not null);
desc author;
select * from author;
select  Author_name,about,new_book,address,firstbook_releasedyear from author where author_id =1;
drop  table author;
create table supplier(supplier_id int primary key auto_increment ,name varchar(50) not null,
phone long not null,address varchar(50) not null,mail_Id varchar(50) not null,
password varchar(50) not null);
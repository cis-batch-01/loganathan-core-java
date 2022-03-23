create database library_manager;
use library_manager;
create table author(Author_id int not null auto_increment ,Author_name varcha(50) not null,about varchar(50) not null,new_book(50) not null,
address varchar(50) not null,lastbook_realeasedyear(50)not null);
desc author;
select * from author;
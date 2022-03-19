create database coursemanagement;
use coursemanagement;
create table topic(topic_id int  primary key auto_increment,topic_name varchar(50)not null,
description varchar(50) not null,content varchar(50) not null,date datetime not null);
desc  topic;
select * from  topic;
create table question(question_id int  primary key auto_increment,question_content varchar(50) not null,
topic_name varchar(50)not null);
desc  question;
select * from  question;
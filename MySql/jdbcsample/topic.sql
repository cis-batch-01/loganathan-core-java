create database topicsample;
use topicsample;
create table  topic(topic_id int primary key auto_increment,topic_name varchar(40) not null,
description varchar(100) not null,content varchar(30) not null,created_date Date not null,updated_date date not null);
insert into topic (topic_name,description,content,created_date,updated_date) values("java","developer","middle",'2000-03-20','2004-03-20');
select topic_id,topic_name,description,content,created_date,updated_date from topic;

desc topic;
drop table topic;
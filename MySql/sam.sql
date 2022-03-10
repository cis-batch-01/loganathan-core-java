create database test;
use test;
show databases;
show tables;
create table Trainer_Info(Trainer_Id int(5),
Salutation varchar(20),
Trainer_Name varchar(18),
Trainer_Location varchar(20),
Trainer_Track varchar(20),
Trainer_Qualification varchar(20),
Trainer_Experiance int(5),
Trainer_Email varchar(30),
Trainer_Password varchar(30)
);
describe Trainer_Info;
ALTER TABLE Trainer_Info modify Salutation varchar(30);
ALTER TABLE Trainer_Info ADD column prcie double(6,3) after TRAINER_EMAIL; /*add one column*/
ALTER TABLE Trainer_Info modify  prcie double(6,3);
alter table Trainer_Info drop column price;
alter table price  rename Trainer_Info ;                 /*this line used to table name renamed*/
alter table Trainer_Info rename column prcie to price;  /*this line used to column name renamed*/
insert into Trainer_Info values(0,'m','manojjhonson','chennai','lesson','B.E',10,'manojjhonson@gmail.com',5.00,300000,'manojjhonson');
insert into  Trainer_Info value(1,'m', 'babu','chennai','lesson','B.E',8,'babu@gmail.com',5.0,30000,'babu'),
(2,'m','mani','chennai','lesson','B.E',5,'mani@gmail.com',4.0,30000,'mani'); /*insert data to table*/
select* from Trainer_Info;  /*show table data*/
truncate Trainer_Info;  /*delete all row data*/
delete from Trainer_Info where Trainer_Location='chennai';/*delete based where condition*/
set sql_safe_updates=0;/*for data security*/
update Trainer_Info set Trainer_Location='Sholinghur'  where Trainer_Name='babu';/*update*/
create table Batch_Info(Batch_Id int(5),
Batch_Owner  varchar(10),
Batch_BU_Name  varchar(10)
);
describe Batch_Info;
create table Module_Info(Module_Id   varchar(10),
Module_Name  varchar(10),
Module_Duration   int (10)
);
describe Module_Info;
create table  Associate_Info(Associate_Id   varchar(10),Salutation  varchar(10),
Associate_Name   varchar(20),
Associate_Location  varchar(40),
Associate_Track    varchar(10),
Associate_Qualification  varchar(50),
Associate_Email  varchar(50),
Associate_Password  varchar(10)
);
describe Associate_Info;
create table Question( Question_Id  varchar(20),
Module_Id  varchar(20),
Question_Text   varchar(100)
);
describe Question;
create table Associate_Status(Associate_Id  varchar(20),
Module_Id varchar(20),
Start_Date varchar(20),
End_Date varchar(20),
AFeedbackGiven varchar(20), 
TFeedbackGiven varchar(20)
);
describe  Associate_Status;
create table Trainer_Feedback(Trainer_Id   varchar(20),
Question_Id  varchar(20),
Batch_Id  varchar(20),
Module_Id  varchar(20),
Trainer_Rating  integer(20)

);
desc Trainer_Feedback;
create table Associate_Feedback(Associate_Id  varchar(20),
Question_Id  varchar(20),
Module_Id  varchar(20),
Associate_Rating  integer(20)

);
describe  Associate_Feedback;

create table Login_Details(User_Id varchar(20),
User_Password varchar(20)
 
);
describe Login_Details;

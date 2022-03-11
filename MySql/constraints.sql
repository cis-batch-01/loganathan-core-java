create database course;
use course;
show databases;
show tables;
create table Trainer_Info(Trainer_Id int primary key,
Salutation varchar(20) NOT NULL,
Trainer_Name varchar(18) NOT NULL,
Trainer_Location varchar(20) NOT NULL,
Trainer_Track varchar(20) NOT NULL,
Trainer_Qualification varchar(100) NOT NULL,
Trainer_Experiance int ,
Trainer_Email varchar(100) NOT NULL,
Trainer_Password varchar(30) NOT NULL,
constraint chk_Trainer_Info check(Trainer_Id like 'F%')
);
describe Trainer_Info;
insert into Trainer_Info values('F001','Mr.','PANKAJ GHOSH','Pune','Java','Bachelor of Technology',12,'Pankaj.Ghosh@alliance.com','fac1@123');
insert into Trainer_Info values('F002','Mr.','BABU','SHOLINGUR','Java','Bachelor of Technology',10,'babu@alliance.com','fac2@123');
insert into Trainer_Info values('L001','Mr.','MANI','TNR','Java','Bachelor of Application',8,'mani@alliance.com','fac3@123');
alter table Trainer_Info  modify Trainer_Id varchar(20);
select * from Trainer_Info;
create table Batch_Info(Batch_Id varchar(20) primary key,
Batch_Owner  varchar(30) NOT NULL,
Batch_BU_Name  varchar(30) NOT NULL,
constraint chk_Batch_Info check(Batch_Id like 'B%')
);
drop table Batch_Info;
describe Batch_Info;
insert into Batch_Info values('B001','MRS.SWATI ROY','MSP');

select * from Batch_Info;

create table Module_Info(Module_Id   varchar(20) NOT NULL,
Module_Name  varchar(40) NOT NULL,
Module_Duration   int primary key

);
drop table Module_Info;

insert into  Module_Info values ('J2SE','Core java SE 1.6',288),('J2EE','Advanced Java EE 1.6',80),('O10PLSQL','Oracle 10g PL/ SQL ',16);
select *from  Module_Info;

describe Module_Info;

create table  Associate_Info (Associate_Id varchar(20) primary key,
Salutation varchar(7) NOT NULL,
Associate_Name varchar(30) NOT NULL,
Associate_Location varchar(30) NOT NULL ,
Associate_Track varchar(15) NOT NULL ,
Associate_Qualification varchar(200) NOT NULL ,
Associate_Email varchar(100) NOT NULL,
Associate_Password varchar(20) NOT NULL,
constraint chk_Associate_Info check(Associate_Id like 'A%')

);
desc Associate_Info;
insert into Associate_Info values('A001','Miss.','GAYATHRI NARAYANAN','Gurgaon','Java','Bachelor of Technology','Gayathri.Narayanan@hp.com','tne1@123');
insert into Associate_Info values('A002','Mrs.','RADHIKA MOHAN','Kerala','Java','Bachelor of Information Technology','RadhikaMohan@cognizant.com','tne2@123');
select * from Associate_Info;

create table Questions(Question_Id varchar(20) primary key,
Module_Id varchar(20)  references Module_Info.Module_Id ,  /*foreign key*/
Question_Text varchar(900) NOT NULL,
constraint chk_Question check(Question_Id like 'Q%')
);
desc Questions;
insert into Questions values('Q001','EM001','Instructor knowledgeable and able to handle all your queries');
insert into Questions values ('Q002','EM001','All the topics in a particular course handled by the trainer without any gaps or slippages');
select *from Questions;




create table Associate_Status(Associate_Id varchar(20) NOT NULL references Associate_status.Associate_Id,
Module_Id varchar(20)NOT NULL references Associate_status.Module_Id,
Start_Date varchar(20)NOT NULL references Associate_status.Start_Date,
End_Date varchar(20)NOT NULL references Associate_status.End_Date,
AFeedbackGiven varchar(20),
TFeedbackGiven varchar(20)
);
desc Associate_Status;
select *from Associate_Status;
insert into Associate_Status values('A001','O10SQL','B001','F001',2000-12-15,2000-12-25),
('A002','O10SQL','B001','F001',2000-12-15,2000-12-25);

create table Trainer_Feedback(Trainer_Id varchar(20) NOT NULL references Trainer_Feedback.Trainer_Id ,
Question_Id varchar(20) NOT NULL references Trainer_Feedback.Question_Id  ,
Batch_Id varchar(20) NOT NULL references Trainer_Feedback.Batch_Id ,
Module_Id varchar(20) NOT NULL references Trainer_Feedback. Module_Id,
Trainer_Rating int 
);
desc Trainer_Feedback;
select* from Trainer_Feedback;
insert into Trainer_Feedback values('T001','Q001','B001','M001',4),('T002','Q002','B002','M002',8);


create table Associate_Feedback(Associate_Id varchar(20) NOT NULL references Associate_Feedback.Associate_Id ,
Question_Id varchar(20) NOT NULL references Associate_Feedback.Question_Id,
Module_Id varchar(20) NOT NULL references Associate_Feedback.Module_Id,
Associate_Rating int
);
desc Associate_Feedback;
select *from Associate_Feedback;
insert into Associate_Feedback  values('A001','Q001','M001',4),('A002','Q002','M002',7);

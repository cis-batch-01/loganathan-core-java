CREATE DATABASE `lms` ;
USE `lms`;
drop table image;
CREATE TABLE `image` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into image values('p001','2000-02-20','2005-03-25','java','java.jpeg');
insert into image values('p002','2002-03-20','2005-04-25','angular','angular.jpeg');
insert into image values('p003','2005-04-20','2005-05-25','c','c.jpeg');
insert into image values('p004','2000-05-20','2005-06-25','mysql','mysql.jpeg');
insert into image values('p005','2006-02-20','2007-03-25','mongodb','mongodb.jpeg');
insert into image values('p006','2006-02-20','2007-03-25','react','react.jpeg') ;
DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `logo_id` varchar(36) DEFAULT NULL,
  `license` enum('INTERNAL','EXTERNAL','FULL','TRIAL') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `organization_logo_id_unique` (`logo_id`),
  KEY `organization_logo_id_index` (`logo_id`),
  CONSTRAINT `organization_logo_id_foreign` FOREIGN KEY (`logo_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into organization values('org001','2000-02-20','2005-03-25','tcs','www.tcs.com','tcs.in','p001','full') ;
insert into organization values('org002','2002-02-22','2003-03-25','wipro','www.wipro.com','wipro.in','p002','EXTERNAL') ;
insert into organization values('org003','2003-02-25','2004-03-20','hcl','www.hcl.com','hcl.in','p003','TRIAL') ;
insert into organization values('org004','2004-04-20','2005-03-25','vitech','www.vitech.com','vitech.in','p004','INTERNAL') ;
insert into organization values('org005','2005-02-20','2006-03-25','intel','www.intel.com','intel.in','p005','full') ;
DROP TABLE `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `default` tinyint(1) NOT NULL,
  `organization_id` varchar(36) DEFAULT NULL,
  `key` varchar(255) NOT NULL,
  `permissions` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_organization_id_index` (`organization_id`),
  CONSTRAINT `role_organization_id_foreign` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r001','2000-02-20','2005-03-25','student',' recent learning ','1',
'1','org001','k001','accept') ;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r002','2000-02-23','2005-03-20','alumni',' already learned student ','0',
'0','org002','k002','accept') ;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r003','2000-02-24','2005-03-25','admin',' office work ','1',
'1','org003','k003','accept') ;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r004','2000-02-21','2005-03-24','student',' recent learning ','1',
'1','org004','k004','accept') ;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r005','2000-02-23','2005-03-27','alumni',' office work ','1',
'1','org005','k005','accept') ;
insert into role(`id`,`created_at` ,`updated_at` ,`title` ,`description` ,`active` ,`default` ,`organization_id` ,
`key` ,`permissions` ) values('r006','2000-02-23','2005-03-27','instructor',' office work ','1',
'1','org005','k006','accept') ;
drop table user;

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `address` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`address`)),
  `display_picture_id` varchar(36) DEFAULT NULL,
  `organization_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_display_picture_id_unique` (`display_picture_id`),
  KEY `user_display_picture_id_index` (`display_picture_id`),
  KEY `user_organization_id_index` (`organization_id`),
  CONSTRAINT `user_display_picture_id_foreign` FOREIGN KEY (`display_picture_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_organization_id_foreign` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`,`organization_id`) values('u001','2000-02-20','2005-03-25','logan','ramesh','logu@gmail.com','Logan'
,'1999-06-15','{"area":"sholinghur","state":"tn"}','p001','org001');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`,`organization_id`) values('u002','2000-02-23','2005-03-28','babu','ramesh','babu@gmail.com','Babu'
,'2001-06-18','{"area":"sholinghur","state":"tn"}','p002','org002');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`,`organization_id`) values('u003','2000-04-23','2005-05-28','mani','gopal','mani@gmail.com','Mani'
,'2001-06-18','{"area":"tvm","state":"tn"}','p003','org003');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`,`organization_id`) values('u004','2000-04-25','2005-05-29','venu','gopal','venu@gmail.com','Vneu'
,'1988-06-18','{"area":"pkm","state":"tn"}','p004','org004');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`,`organization_id`) values('u005','2000-04-25','2005-05-29','bhoopathi','mani','bhoopathi@gmail.com','Bhoopathi'
,'1988-06-18','{"area":"sp","state":"tn"}','p006','org005');
DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_roles_user_id_index` (`user_id`),
  KEY `user_roles_role_id_index` (`role_id`),
  CONSTRAINT `user_roles_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_roles_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into user_roles(`user_id`,`role_id`)values('u001','r001');
insert into user_roles(`user_id`,`role_id`)values('u002','r002');
insert into user_roles(`user_id`,`role_id`)values('u003','r003');
insert into user_roles(`user_id`,`role_id`)values('u004','r004');
insert into user_roles(`user_id`,`role_id`)values('u005','r006');
drop table instructor;
CREATE TABLE `instructor` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `tagline` varchar(255) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `instructor_user_id_unique` (`user_id`),
  KEY `instructor_user_id_index` (`user_id`),
  CONSTRAINT `instructor_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
delete from instructor where user_id="u004";
update  instructor set  user_id='u005' where id='s001';
set sql_safe_updates=0;
select * from instructor;
select * from user;
insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s001','2000-04-25','2005-05-29','java trainer','office,college placement ','u002');
/*insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s002','2000-04-21','2005-05-25','backend trainer','office,college placement ','u002');
insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s003','2000-04-22','2005-05-29','full stack trainer','office,college placement ','u003');
insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s004','2000-04-25','2005-05-29','frontend devloper trainer','office,college placement ','u004');*/
insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s005','2000-04-25','2005-05-29','frontend devloper trainer','office,college placement ','u005');
DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `status` enum('DRAFT','PUBLISHED','ARCHIVED','DELETED') NOT NULL,
  `duration` varchar(255) NOT NULL,
  `level` enum('BEGINNER','INTERMEDIATE','ADVANCED') NOT NULL,
  `price` double NOT NULL,
  `rating` double NOT NULL,
  `rating_count` int NOT NULL,
  `instructor_id` varchar(36) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `banner_id` varchar(36) DEFAULT NULL,
  `cover_id` varchar(36) DEFAULT NULL,
  `curriculum` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`curriculum`)),
  `visibility` enum('PUBLIC','INTERNAL') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_banner_id_unique` (`banner_id`),
  UNIQUE KEY `course_cover_id_unique` (`cover_id`),
  KEY `course_instructor_id_index` (`instructor_id`),
  KEY `course_banner_id_index` (`banner_id`),
  KEY `course_cover_id_index` (`cover_id`),
  CONSTRAINT `course_banner_id_foreign` FOREIGN KEY (`banner_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_cover_id_foreign` FOREIGN KEY (`cover_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_instructor_id_foreign` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
update  course set  instructor_id='s005' where id='c005';

insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c001','2000-04-25','2005-05-29','java rprogramming','java frontend','PUBLISHED','40days','BEGINNER',20000,4,0
  ,'s005','jf001','p001','p001','{"introduction":"3days","java progrmming and oops":"7days",
  "Advance java":"15days","jdbc":"10days"}','PUBLIC');
  insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c002','2000-04-29','2005-05-29','java programming','java full stack','PUBLISHED','90days','INTERMEDIATE',40000,4.5,0
  ,'s005','jf002','p002','p002','{"introduction":"3days","java progrmming and oops":"13days",
  "Advance java":"25days"," full jdbc":"25days"}','PUBLIC');
  insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c004','2005-04-30','2010-05-29','java programming','java full stack','PUBLISHED','120days','ADVANCED',50000,4.5,0
  ,'s005','jf003','p003','p003','{"introduction":"3days","java progrmming and oops":"25days",
  "Advance java":"30days"," full jdbc":"30pdays"}','PUBLIC');
  insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c004','2005-04-30','2010-05-29','react','front-end devloper','PUBLISHED','90days','ADVANCED',50000,4.5,0
  ,'s005','re001','p004','p004','{"introduction":"3days"," progrmming ":"25days",
  "Advance ":"30days"}','INTERNAL');
  insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c005','2005-04-30','2010-05-29','mongodb','backendevloper','ARCHIVED','90days','ADVANCED',50000,4.5,0
  ,'s005','mdb001','p005','p005','{"introduction":"3days"," rest api  ":"25days",
  "Express ,node js ":"30days"}','INTERNAL');
  insert into course( `id`,`created_at` ,`updated_at` ,`title` ,`description` ,`status` ,`duration` ,`level` ,`price` ,
  `rating` ,`rating_count` ,`instructor_id` ,`code` ,`banner_id` ,`cover_id` ,`curriculum` ,`visibility`)
  values('c006','2005-04-30','2010-05-29','html','wep devlopment','PUBLISHED','60days','INTERMEDIATE',20000,4.5,0
  ,'s005','mdb001','p006','p006','{"introduction":"3days"," codeing  ":"25days",
  "css ":"30days"}','INTERNAL');
  update course set  code='html001' where id='c006';
  select * from course;
DROP TABLE IF EXISTS `category`;
update category set  parent_id='null' where id='cat2';

CREATE TABLE `category` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_parent_id_index` (`parent_id`),
  CONSTRAINT `category_parent_id_foreign` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
select * from category;
delete from category ;

insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat1','2022-09-01','2022-09-06','Front-end','fe','Designing the page',0);
insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat2','2022-06-03','2022-06-05','Front-end','we','Designing the page',1);
insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat3','2021-06-09','2021-06-11','middle-ware',"fa",'designing the page',0);
insert into `category` (id,created_at,updated_at,title,slug,description,parent_id,enabled)
values('cat4','2022-09-03','2022-09-05','js','wa','connect fa and wa','cat2',0);
insert into `category` (id,created_at,updated_at,title,slug,description,parent_id,enabled)
values('cat5','2022-06-05','2022-06-09',' jsp','sa','connect wa and sa','cat1',0);
insert into `category` (id,created_at,updated_at,title,slug,description,enabled)
values('cat6','2022-06-05','2022-06-09',' backend','sa','connect to frontend',0);
DROP TABLE IF EXISTS `category_courses`;
CREATE TABLE `category_courses` (
  `category_id` varchar(36) NOT NULL,
  `course_id` varchar(36) NOT NULL,
  PRIMARY KEY (`category_id`,`course_id`),
  KEY `category_courses_category_id_index` (`category_id`),
  KEY `category_courses_course_id_index` (`course_id`),
  CONSTRAINT `category_courses_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `category_courses_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 insert into category_courses( `category_id`,`course_id` )values('cat5','c001');
insert into category_courses( `category_id`,`course_id` )values('cat5','c002');
insert into category_courses( `category_id`,`course_id` )values('cat5','c003');
insert into category_courses( `category_id`,`course_id` )values('cat1','c001');
insert into category_courses( `category_id`,`course_id` )values('cat6','c005');

drop table course_pre_requisites;
CREATE TABLE `course_pre_requisites` (
  `course_1_id` varchar(36) NOT NULL,
  `course_2_id` varchar(36) NOT NULL,
  PRIMARY KEY (`course_1_id`,`course_2_id`),
  KEY `course_pre_requisites_course_1_id_index` (`course_1_id`),
  KEY `course_pre_requisites_course_2_id_index` (`course_2_id`),
  CONSTRAINT `course_pre_requisites_course_1_id_foreign` FOREIGN KEY (`course_1_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_pre_requisites_course_2_id_foreign` FOREIGN KEY (`course_2_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
drop table course_pre_requisites;


insert into course_pre_requisites(`course_1_id`,`course_2_id`)values('c002','c001');
insert into course_pre_requisites(`course_1_id`,`course_2_id`)values('c004','c003');
select * from course;
select * from course_pre_requisites;
CREATE TABLE `course_students` (
  `course_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `course_students_course_id_index` (`course_id`),
  KEY `course_students_user_id_index` (`user_id`),
  CONSTRAINT `course_students_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_students_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
drop table course_students;
insert into course_students(`course_id`,`user_id`)values('c001','u001');
insert into course_students(`course_id`,`user_id`)values('c002','u001');
insert into course_students(`course_id`,`user_id`)values('c001','u004');
insert into course_students(`course_id`,`user_id`)values('c006','u003');
select * from user;
select *from user;
SELECT * FROM INSTRUCTOR;
CREATE TABLE `migrations` (
  `id` int  unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `executed_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

drop table migrations;

--


--
DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `provider` varchar(255) NOT NULL,
  `ref` varchar(255) NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


/*1. Write a query to display all the available course categories?
3.write a query to get coursename, count of students in each course
4. write a query to get username ,email, role of all the users

6.write a query to show the name of the course,no of Students in course java
7.write a query to show all the course details of Back End
8.Write a query to show the payment details*/

show tables;
/*1. Write a query to display all the available course categories?*/
use lms;
select * from category_courses;
select title,description,duration,level from course;
/*2.write a query to get the Organization title and website Address.*/

select name,website from Organization;

/*3.write a query to get coursename, count of students in each course*/
select * from course;
select course.title,count(course_students.user_id ) as count_of_students  from course_students 
join course on course.id = course_students.course_id ;

/*4.write a query to get username ,email, role of all the users*/
select * from user ;
select * from user_roles;
select * from role;
select user.first_name,user.email ,role.title as role from user 
join user_roles on user_roles.user_id=user.id
join role on user_roles.role_id=role.id;

/*5. write a query to show the all the sub categiries of category 'frontEnd';*/
select * from category  ;
select * from category where parent_id in
(select id from category where title="Front-end");
/*6.write a query to show the name of the course,no of Students in course java*/
select * from course;         
select * from course_students;
select course.title,count(user_id)Student_List from course
join course_students as cs on course.id=cs.course_id where title="java rprogramming";
/*7.write a query to show all the course details of Front-end*/
select * from category;
select * from category where  title="Front-end";

/*9.Write a query to course name and instructor name*/
select * from course;
select * from instructor;
select *from user;

select course.title,user.first_name
from course 
join instructor on course.instructor_id =instructor.id
join user on instructor.user_id=user.id;
/*10.Write a query to get all the course under 50000.*/
select * from course where price<"50000" ;

/*11.write a query to fetch all the corses for the user from organization org003*/
select * from course ;
select * from  organization where organization.id="org001";
select * from organization ;
select * from user;
select * from course_students;
select* from course;
 
/*where course.visibility ="public" and organization.license="" ;*/


/**********/

select * from organization;
select * from course_students;
select * from course
 join course_students on course_students.course_id=course.id
join user on user.id=course_students.user_id 
join organization on user.organization_id=organization.id
where organization.license="u001";
/*******************************/
select * from organization;
select* from course;
/*check course visible and organization license */
/*full*/
select course.id,course.title,course.description,course.price,course.duration from course
 join course_students on course_students.course_id=course.id
join user on user.id=course_students.user_id 
join organization on user.organization_id=organization.id
where visibility ='internal' ||visibility ='public';
/*trial*/
select course.id,course.title,course.description,course.price,course.duration from course
 join course_students on course_students.course_id=course.id
join user on user.id=course_students.user_id 
join organization on user.organization_id=organization.id
where visibility ='internal' ||visibility ='public';
/*internal */
select course.id,course.title,course.description,course.price,course.duration from course
 join course_students on course_students.course_id=course.id
join user on user.id=course_students.user_id 
join organization  on user.organization_id=organization.id
where organization.id='org003'  and visibility='internal';
/*External*/
select id,title,description,price,duration from course where visibility='public';




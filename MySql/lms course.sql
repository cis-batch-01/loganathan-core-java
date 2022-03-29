CREATE DATABASE `lms` ;
USE `lms`;
CREATE TABLE `image` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into image values('first','2000-02-20','2005-03-25','java','java.jpeg');
insert into image values('second','2002-03-20','2005-04-25','angular','angular.jpeg');
insert into image values('Third','2005-04-20','2005-05-25','c','c.jpeg');
insert into image values('fourth','2000-05-20','2005-06-25','mysql','mysql.jpeg');
insert into image values('fifth','2006-02-20','2007-03-25','mongodb','mongodb.jpeg');
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
insert into organization values('c001','2000-02-20','2005-03-25','tcs','www.tcs.com','tcs.in','first','full') ;
insert into organization values('c002','2002-02-22','2003-03-25','wipro','www.wipro.com','wipro.in','second','EXTERNAL') ;
insert into organization values('c003','2003-02-25','2004-03-20','hcl','www.hcl.com','hcl.in','third','TRIAL') ;
insert into organization values('c004','2004-04-20','2005-03-25','vitech','www.vitech.com','vitech.in','fourth','INTERNAL') ;
insert into organization values('c005','2005-02-20','2006-03-25','intel','www.intel.com','intel.in','fifth','full') ;
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
insert into role values('r001','2000-02-20','2005-03-25','student',' recent learning ','1',
'1','c001','k001','accept') ;
insert into role values('r002','2000-02-23','2005-03-20','alumni',' already learned student ','0',
'0','c002','k002','accept') ;
insert into role values('r003','2000-02-24','2005-03-25','admin',' office work ','1',
'1','c003','k003','accept') ;
insert into role values('r004','2000-02-21','2005-03-24','student',' recent learning ','1',
'1','c004','k004','accept') ;
insert into role values('r005','2000-02-23','2005-03-27','alumni',' office work ','1',
'1','c005','k005','accept') ;

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
/*!40101 SET character_set_client = @saved_cs_client */;
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`) values('u001','2000-02-20','2005-03-25','logan','ramesh','logu@gmail.com','Logan'
,'1999-06-15','{"area":"sholinghur","state":"tn"}','first');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`) values('u002','2000-02-23','2005-03-28','babu','ramesh','babu@gmail.com','Babu'
,'2001-06-18','{"area":"sholinghur","state":"tn"}','second');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`) values('u003','2000-04-23','2005-05-28','mani','gopal','mani@gmail.com','Mani'
,'2001-06-18','{"area":"tvm","state":"tn"}','third');
insert into user (`id`, `created_at`,  `updated_at`,`first_name`,`last_name`,`email` ,`password`,
`date_of_birth`,`address`, `display_picture_id`) values('u004','2000-04-25','2005-05-29','venu','gopal','venu@gmail.com','Vneu'
,'1988-06-18','{"area":"pkm","state":"tn"}','fourth');
DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_roles_user_id_index` (`user_id`),
  KEY `user_roles_role_id_index` (`role_id`),
  CONSTRAINT `user_roles_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_roles_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
insert into user_roles(`user_id`,`role_id`)values('u001','r001');
insert into user_roles(`user_id`,`role_id`)values('u002','r002');
insert into user_roles(`user_id`,`role_id`)values('u003','r003');
insert into user_roles(`user_id`,`role_id`)values('u004','r004');

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
insert into instructor(`id`,`created_at`,`updated_at` ,`bio` ,`tagline` ,`user_id`) 
values('s001','2000-04-25','2005-05-29','java trainer','office,college placement ','u001');

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `status` enum('DRAFT','PUBLISHED','ARCHIVED','DELETED') NOT NULL,
  `duration` varchar(255) NOT NULL,
  `level` enum('BEGINNER','INTERMEDIATE','ADVANCED') NOT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `rating_count` int(11) NOT NULL,
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
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `category`;

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

insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat1','2022-09-01','2022-09-06','Front-end','fe','Designing the page',0);
insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat2','2022-06-03','2022-06-05','Front-end','we','Designing the page',1);
insert into `category` (`id`,`created_at`,`updated_at`,`title`,`slug`,`description`,`enabled`)
values('cat3','2021-06-09','2021-06-11','middle-ware',"fa",'designing the page',0);
insert into `category` (id,created_at,updated_at,title,slug,description,parent_id,enabled)
values('cat4','2022-09-03','2022-09-05','back-end','wa','connect fa and wa','cat2',0);
insert into `category` (id,created_at,updated_at,title,slug,description,parent_id,enabled)
values('cat5','2022-06-05','2022-06-09','back-end','sa','connect wa and sa','cat1',0);
DROP TABLE IF EXISTS `category_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_courses` (
  `category_id` varchar(36) NOT NULL,
  `course_id` varchar(36) NOT NULL,
  PRIMARY KEY (`category_id`,`course_id`),
  KEY `category_courses_category_id_index` (`category_id`),
  KEY `category_courses_course_id_index` (`course_id`),
  CONSTRAINT `category_courses_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `category_courses_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;





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



CREATE TABLE `course_students` (
  `course_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `course_students_course_id_index` (`course_id`),
  KEY `course_students_user_id_index` (`user_id`),
  CONSTRAINT `course_students_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_students_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



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





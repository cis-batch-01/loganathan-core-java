/*
16.write a query to fetch all the course for user from org01*/
use lms;
/*12.write a query to display only the admins name and email ,permissions*/

select  title as role_name,user.email ,permissions from  role 
join user  on user.organization_id=role.organization_id;

/*13.write a query to display all  courses published and its category name*/

/*select course.created_at ,category.title from course 
join category on category.id= course.id;*/
select course.status,category.title from course
join category_courses as cc on course.id=cc.course_id
join category on cc.category_id=category.id
where course.status="published";

/*14.write a query to display all advanced courese*/

show tables;
select course.title,course.level from course where level="advanced";
/*15.write a query to display instructor name and email ,teaching the biginner level courses*/

select  user.first_name,user.email from  user 
 join instructor on  instructor.user_id= user.id
 join course on course.instructor_id=instructor.id where course.level="BEGINNER"; 
 
 /*16.write a query to fetch all the course for user from org001*/
select * from user; 
select user.id,user.first_name from course
 join course_students on course_students.course_id=course.id
join user on user.id=course_students.user_id 
join organization on user.organization_id=organization.id
where organization.id="org001";
/*17.write a query to show all the subcategory name and its courses for 'backend'*/

select * from  role;
select * from  organization;
select  * from  user; 
select  * from  course; 
select * from instructor;
 select * from category_courses;
 select * from   category;
select course.title from  course
 join  category_courses as cc on course.id=cc.course_id 
 join category as c on c.id=cc.category_id 
where course.description="backendevloper";

/*18.write a query course title ,description,duration,price  course_pre_requisites*/
select * from course_pre_requisites;
select *from course;

(select sc.title,sc.description,sc.level,sc.duration,sc.price,cpr.course_1_id from course as sc
join course_pre_requisites as cpr on cpr.course_2_id=sc.id )union
(select c.title,c.description,c.level,c.duration,c.price,cpr.course_1_id from course as c
join course_pre_requisites as cpr on cpr.course_1_id=c.id );

/*19.display user email,role name, which org */
select * from user;
select * from role;
select * from organization ;
select u.email,r.title , r.organization_id,org.name from user  as u 
join  role as r on r.organization_id=u.organization_id
join organization as org on org.id=u.organization_id;

/*20.*/



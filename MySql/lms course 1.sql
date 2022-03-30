/*12.write a query to display only the admins name and email ,permissions

14.write a query to display all advanced courese
15.write a query to display instructor name and email ,teaching the biginner level courses
16.write a query to fetch all the course for user from org01
17.write a query to show all the subcategory name and its courses for 'backend'*/
use lms;
/*12.write a query to display only the admins name and email ,permissions*/


select  title as role_name,user.email ,permissions from  role 
join user  on user.organization_id=role.organization_id;

/*13.write a query to display all  courses published and its category name*/

select * from  role;
select * from  organization;
select  * from  user; 
show tables;
select * from course;
select * from category;

/*select course.created_at ,category.title from course 
join category on category.id= course.id;*/
select course.status,category.title from course
join category_courses as cc on course.id=cc.course_id
join category on cc.category_id=category.id
where course.status="published";
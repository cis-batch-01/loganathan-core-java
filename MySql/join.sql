/* 1.Write a query to display the names of all administrators (role Admin) sorted by name in
ascending order*/
use AMS;
select user.name,role.name from user
join role on role.id=user.role_id
where role.name="admin" order by user.name asc;
/*ailes*/
select u1.name as UserName,r1.name as Role from user as u1
join role as r1 on r1.id=u1.role_id
where r1.name="admin" order by u1.name asc;
/*2.Write a query to display the names of all alumni (role Alumni) sorted by name in descending
order.*/
select u1.name as UserName,r1.name as Role from user as u1
join role as r1 on r1.id=u1.role_id
where r1.name="alumni" order by u1.name desc;

/*3.Write a query to display the names of all degrees offered by 'CSE' department, sorted in
ascending order*/
select d1.name as degree,d2.name as department from degree as d1
join department as d2 on d2.ID= d1.DEPARTMENT_Id 
where  d2.name="CSE" order by d1.NAME asc;
/*4.Write a query to display the name of the department offering the degree 'BSC_CT'*/
select* from department;
select *from degree;
select degree.name,department.name from department
join degree on degree.DEPARTMENT_ID=department.id where degree.name="BSC_CT";
/*5. Write a query to display the names of all female alumni (role Alumni), sorted in order.*/

select user.name from user join role on  role_id= role.id  join profile on user.PROFILE_ID=profile.id
where  role.name="alumni" and profile.GENDER="female";
select *from user ;
select * from profile;
select * from role;

select user.name,role.name from user join role on role.id
join profile on PROFILE_ID=user_id
where user.name="alumni" and gender="female" order by name;
/*6. Write a query to display the name of all Alumni from BSC_CT 2012 batch, sorted by name*/
select*from degree;
select * from user;
insert into user (id, emailid,name,password,phonenumber,profile_id,role_id,username)values
(4,'KAVITHA@LYCOS.COM','KAVITHA','AMPHI567','9111193459',4,2,'USER04');
insert into user (id, emailid,name,password,phonenumber,profile_id,role_id,username)values
(5,'Manoj@LYCOS.COM','Manoj','AMPHI567','9111193459',5,2,'USER05');

select * from profile;

select * from  user  
join  role on user.role_id= role.id 
join profile on user.profile_id= profile.id
join degree on profile.DEGREE_ID = degree.id where role.name="alumni"  and profile.batch="2012";

select *from degree;
select *from department;
select * from role;

/*7.Write a query to display the name of all Alumni of 2008 batch from CSE department, sorted by
name.
*/
select*  from user
join role on user.role_id=role.id
join  profile on user.PROFILE_ID=profile.id
join degree on degree.ID=profile.DEGREE_ID
join department on degree.DEPARTMENT_ID=DEPARTMENT_ID 
where role.name="alumni"  and profile.batch="2008" and  department.NAME="CSE"  order by user.name asc;

select *from degree;
select *from department;
select * from role;
select * from user;

/*8. Write a query to display the entire contents of the table after performing a left join on role table
and user table, sorted by role name and then by name of the user.

*/ 
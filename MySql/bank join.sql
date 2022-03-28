Create Database Bank; 
Use Bank; 
CREATE TABLE customer_master( CUSTOMER_NUMBER
VARCHAR(6), FIRSTNAME VARCHAR(30), middlename VARCHAR(30), lastname
VARCHAR(30), CUSTOMER_CITY VARCHAR(15), CUSTOMER_CONTACT_NO
VARCHAR(10), occupation VARCHAR(10), CUSTOMER_DATE_OF_BIRTH DATE,
CONSTRAINT customer_custid_pk PRIMARY KEY (CUSTOMER_NUMBER) ); 

CREATE TABLE branch_master( branch_id VARCHAR(6), branch_name VARCHAR(30), branch_city
VARCHAR(30), CONSTRAINT branch_bid_pk PRIMARY KEY (branch_id) );

 CREATE TABLE
account_master (account_number VARCHAR(255), customer_number VARCHAR(255),
branch_id VARCHAR(255), opening_balance INT, account_opening_date DATE,
account_type VARCHAR(10), account_status VARCHAR(10), PRIMARY KEY
(account_number), FOREIGN KEY (customer_number) references
customer_master(customer_number), FOREIGN KEY (branch_id) references
branch_master(branch_id) ); 
drop table account_master;
CREATE TABLE transaction_details( transaction_number
VARCHAR(6), account_number VARCHAR(6), date_of_transaction DATE,
medium_of_transaction VARCHAR(20), transaction_type VARCHAR(20), transaction_amount
int , CONSTRAINT transaction_details_tnumber_pk PRIMARY KEY (transaction_number),
CONSTRAINT transaction_details_acnumber_fk FOREIGN KEY (account_number)
REFERENCES account_master (account_number) ); 

create table
loan_details(customer_number varchar(255), branch_id varchar(255), loan_amount bigint,
foreign key(customer_number) references customer_master(customer_number));
 
 drop table loan_details;
 insert into
customer_master values('C00001', 'RAMESH', 'CHANDRA', 'SHARMA', 'DELHI', '9543198345',
'SERVICE' ,'1976-12-06'); 
insert into customer_master values('C00002', 'AVINASH', 'SUNDER',
'MINHA', 'DELHI', '9876532109' ,'SERVICE', '1974-10-16'); 
insert into customer_master
values('C00003', 'RAHUL', NULL, 'RASTOGI', 'DELHI', '9765178901', 'STUDENT', '1981-09-26'); 
insert into customer_master values('C00004', 'PARUL', NULL, 'GANDHI', 'DELHI',
'9876532109' ,'HOUSEWIFE', '1976-11-03'); 
insert into customer_master values('C00005',
'NAVEEN' ,'CHANDRA', 'AEDEKAR', 'MUMBAI', '8976523190', 'SERVICE' ,'1976-09-19'); 
insert
into customer_master values('C00006', 'CHITRESH', NULL, 'BARWE', 'MUMBAI', '7651298321',
'STUDENT' ,'1992-11-06');
 insert into customer_master values('C00007', 'AMIT' ,'KUMAR',
'BORKAR', 'MUMBAI', '9875189761', 'STUDENT', '1981-09-06'); 
insert into customer_master
values('C00008', 'NISHA', NULL, 'DAMLE', 'MUMBAI', '7954198761', 'SERVICE', '1975-12-03');

insert into customer_master values('C00009', 'ABHISHEK', NULL, 'DUTTA', 'KOLKATA'
,'9856198761', 'SERVICE' ,'1973-05-22'); 

insert into customer_master values('C00010',
'SHANKAR' ,NULL, 'NAIR', 'CHENNAI', '8765489076', 'SERVICE', '1976-07-12'); 

insert into branch_master values('B00001', 'ASAF ALI ROAD','DELHI');
 insert into branch_master values('B00002','NEW DELHI MAIN BRANCH','DELHI'); 
insert into branch_master values('B00003' ,'DELHI CANTT', 'DELHI');
 insert into branch_master values('B00004','JASOLA', 'DELHI'); 
 insert into branch_master values('B00005' ,'MAHIM' ,'MUMBAI'); 
 insert into branch_master values('B00006' ,'VILE PARLE', 'MUMBAI'); 
 insert into branch_master values('B00007', 'MANDVI' ,'MUMBAI'); 
 insert into branch_master values('B00008','JADAVPUR', 'KOLKATA'); 
 insert into branch_master values('B00009' ,'KODAMBAKKAM','CHENNAI');
 
 insert into account_master values('A00001' , 'C00001' ,'B00001' ,1000 ,'2012-12-15', 'SAVING', 'ACTIVE');
 insert into account_master values('A00002' ,'C00002' ,'B00001' ,1000,'2012-06-12' ,'SAVING', 'ACTIVE'); 
 insert into account_master values('A00003' ,'C00003','B00002', 1000 ,'2012-05-17' ,'SAVING', 'ACTIVE'); 
insert into account_master values('A00004','C00002', 'B00005', 1000 ,'2013-01-27' ,'SAVING ','ACTIVE'); 
insert into account_master values('A00005' ,'C00006', 'B00006', 1000 ,'2012-12-17' ,'SAVING','ACTIVE'); 
insert into account_master values('A00006' ,'C00007', 'B00007', 1000 ,'2010-08-12' ,'SAVING','SUSPENDED');
 insert into account_master values('A00007' ,'C00007', 'B00001', 1000 ,'2012-10-02' ,'SAVING ','ACTIVE');
 insert into account_master values('A00008' ,'C00001' ,'B00003',1000 ,'2009-11-09' ,'SAVING ','TERMINATED');
 insert into account_master values('A00009','C00003', 'B00007', 1000 ,'2008-11-30' ,'SAVING', 'TERMINATED');
 insert into account_master values('A00010' ,'C00004', 'B00002', 1000 ,'2013-03-01' ,'SAVING', 'ACTIVE');
 
 insert into transaction_details values('T00001', 'A00001', '2013-01-01', 'CHEQUE', 'DEPOSIT', 2000);
insert into transaction_details values ('T00002' ,'A00001' ,'2013-02-01' ,'CASH','WITHDRAWAL', 1000);
insert into transaction_details values ('T00003', 'A00002 ', '2013-01-01', 'CASH' ,'DEPOSIT', 2000); 
insert into transaction_details values('T00004', 'A00002', '2013-02-01' , 'CASH' ,'DEPOSIT', 3000);
insert into transaction_details values('T00005', 'A00007','2013-01-11', 'CASH' ,'DEPOSIT', 7000); 
insert into transaction_details values('T00006','A00007', '2013-01-13', 'CASH' ,'DEPOSIT', 9000); 
insert into transaction_details values('T00007', 'A00001', '2013-03-13', 'CASH' ,'DEPOSIT' ,4000); 
insert into transaction_details values('T00008', 'A00001', '2013-03-14', 'CHEQUE' ,'DEPOSIT' ,3000);
insert into transaction_details values('T00009', 'A00001', '2013-03-21', 'CASH' ,'WITHDRAWAL',9000);
 insert into transaction_details values('T00010', 'A00001', '2013-03-22', 'CASH','WITHDRAWAL' ,2000);
 insert into transaction_details values('T00011', 'A00002', '2013-03-25','CASH' ,'WITHDRAWAL' ,7000); 
 insert into transaction_details values('T00012', 'A00007', '2013-03-26', 'CASH' ,'WITHDRAWAL' ,2000);
 
 insert into Loan_details values('C00001', 'B00001',100000); 
 insert into Loan_details values('C00002', 'B00002', 200000); 
 insert into Loan_details values('C00009', 'B00008', 400000);
 insert into Loan_details values('C00010', 'B00009',500000); 
 insert into Loan_details values('C00001', 'B00003', 600000); 
 insert into Loan_details values('C00002', 'B00001', 600000);
 
/* 1.Please follow instructions given below.Write a query to display account number, customer’s
number, customer’s firstname,lastname,account opening date.Display the records sorted in
ascending order based on account number. */
select * from customer_master;
select * from branch_master;
select * from account_master;
select account_master.account_number,customer_master.customer_number,customer_master.firstname,
customer_master.lastname,account_master.account_opening_date
  from customer_master 
join account_master 
on customer_master.customer_number= account_master.customer_number order by customer_master.firstname asc ;

/*2..Please follow instructions given below.Write a query to display the number of customer’s
from Delhi. Give the count an alias name of Cust_Count.*/
select *,count(customer_number) as cn from customer_master 
group by customer_city having customer_city ="delhi";

/*3.Please follow instructions given below.Write a query to display the customer number,
customer firstname,account number for the customer’s whose accounts were created after
15th of any month.Display the records sorted in ascending order based on customer number
and then by account number.*/
 select * from customer_master;
select * from branch_master;
select * from account_master;
select customer_master.customer_number,customer_master.firstname
  from customer_master 
join account_master 
on customer_master.customer_number= account_master.customer_number 
where day(account_master.account_opening_date)>15 
order by account_master.account_number asc;

/*4.Please follow instructions given below.Write a query to display customer number, customer's
first name, account number where the account status is terminated.Display the records sorted
in ascending order based on customer number and then by account number*/
select customer_master.customer_number,customer_master.firstname,account_master.account_number
from customer_master 
join account_master
on customer_master.customer_number=account_master.customer_number
 where account_master.account_status="terminated" order by account_master.account_number asc;
/*19.Write a query to display the customer number,
firstname, lastname for those client where total loan amount taken is maximum and at least
taken from 2 branches.
For example the customer C00012 took a loan of 100000 from bank branch with id B00009 and
C00012
Took a loan of 500000 from bank branch with id B00010. So total loan amount for customer
C00012 is 600000. C00013 took a loan of 100000 from bank branch B00009 and 200000 from
bank branch B00011.So total loan taken is 300000. So loan taken by C00012 is more then  C00013.*/
 select * from customer_master;
select * from branch_master;
select * from account_master;
select * from loan_details;
select customer_master.customer_number,customer_master.firstname,customer_master.lastname,sum(loan_details.loan_amount) as total_loanamount
from customer_master 
join loan_details
 on customer_master.customer_number=loan_details.customer_number ;
 
 /*20.Write a query to display the customer’s number,
customer’s firstname, branch id and loan amount for people who have taken loans..Display the
records sorted in ascending order based on customer number and then by branch id and then
by loan amount.*/
select * from customer_master;
select * from branch_master;
select * from account_master;
select * from loan_details;
select customer_master.customer_number,customer_master.firstname,loan_details.branch_id
from customer_master 
join loan_details
 on customer_master.customer_number=loan_details.customer_number;

 /*21.Please follow instructions given below.Write a query to display city name and count of
branches in that city. Give the count of branches an alias name of Count_Branch.Display the
records sorted in ascending order based on city name.*/
 
 select *,count(branch_city) as count_Branches from branch_master
group by branch_city;
 
 /*22.Write a query to display account id, customer’s firstname, customer’s lastname for the
customer’s whose account is Active.Display the records sorted in ascending order based on
account id /account number.*/
  select * from customer_master;
select * from branch_master;
select * from account_master;
select customer_master.customer_number,customer_master.firstname,customer_master.lastname
from  customer_master
 join account_master 
on customer_master.customer_number=account_master.customer_number 
where account_master.account_status ="Active"
order by customer_master.customer_number,customer_master.firstname asc;
 /*23.Write a query to display customer’s number, first name and middle name. For the customers
who don’t have middle name, display their last name as middle name. Give the alias name as
Middle_Name. */
select   customer_master.customer_number,customer_master.firstname,
coalesce(middlename,lastname)as Middle_name from customer_master;

 /*24.Write a query to display the customer number , firstname, customer’s date of birth . Display
the records sorted in ascending order of date of birth year and within that sort by firstname in
ascending order.*/

select customer_master.customer_number,customer_master.firstname,customer_master.CUSTOMER_DATE_OF_BIRTH
from  customer_master
 join account_master 
on customer_master.customer_number=account_master.customer_number
 order by customer_master.CUSTOMER_DATE_OF_BIRTH,customer_master.firstname asc ;

 /*25.Write a query to display the customers firstname, city and account number whose occupation
are not into Business, Service or Student.Display the records sorted in ascending order based on
customer first name and then by account number.*/

select customer_master.firstname, customer_master.customer_city,account_master.account_number
from  customer_master
 join account_master 
on customer_master.customer_number=account_master.customer_number 
where customer_master.occupation not in ('business', 'service','student') 
order by customer_master.firstname , account_master.account_number asc;

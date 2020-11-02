

use books;

-- drop table book;
create table book (
	id int,
	bName CHARACTER(20),
	price double ,
	authorId int,
	piblicDate DATETIME
);



desc book;


create table if not exists author(
id int,
au_name varchar(20),
nation varchar(10)
);
desc author;


alter table book change column publish date pubDate datetime;


-- alter table book change column piblicDate pubDate datetime;

ALTER table book modify column pubdate timestamp;

desc book;


-- create table book_author (
-- id int,
-- annual int );
alter table book_author drop column annual;

-- desc  book_author;



-- create table author(
-- id int,
-- au_name VARCHAR(20),
-- nation varchar(10));
-- 


insert into author values
(1,'村上春树','日本'),
(2,'莫言','中国'),
(3,'冯唐','中国'),
(4,'金庸','中国'),
(5,'sss','Q'),
(6,'rrr','C');

CREATE TABLE copy LIKE author;



create table coy2 
select * from author;


create table copy3
select id, au_name
from author
where nation = 'Q';

create table co3
select id,nation
from author
where id= 3;


create database if not exists test;

use test;

create table dapt1(
id int,
name varchar(25)
);


create table dept2
select department_id, department_name
from myemployees.departments;


create table emp2 like myemployees.employees;
















mysql> select * from pet;
+----------+--------+-----------+------+------------+------------+
| name     | owner  | species   | sex  | birth      | death      |
+----------+--------+-----------+------+------------+------------+
| Piffball | Dan    | hamer     | f    | 2020-10-10 | NULL       |
| Query    | with   | end       | 1    | 2007-03-03 | NULL       |
| a        | sys    | databases | 1    | 1998-01-02 | NULL       |
| console  | values | birth     | 1    | 1998-01-02 | NULL       |
| password | owners | integer   | 1    | 1998-01-02 | NULL       |
| aaaaa    | bbbbb  | ccccc     | e    | 2000-01-01 | 3000-01-01 |
+----------+--------+-----------+------+------------+------------+
6 rows in set (0.00 sec)



mysql> insert into pet
	-> values('with','b','c','d','2001-1-1',NULL);
	
	insert into pet
	
	
----------------------主键约束---------------------


mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| test               |
+--------------------+
5 rows in set (0.05 sec)

mysql> use test
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| pet            |
+----------------+
1 row in set (0.00 sec)

mysql> create table user(
	-> id int primary key,//这个后面的primary key 就是约束的条件 要求表中的数据不能有重复的key
	-> name varchar(20)
	-> );
Query OK, 0 rows affected (0.04 sec)

mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| pet            |
| user           |
+----------------+
2 rows in set (0.01 sec)

mysql> describe user;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   | PRI | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.01 sec)




--报错
mysql> insert into user values(1,'qq');
Query OK, 1 row affected (0.01 sec)

mysql> insert into user values(1,'qq');
ERROR 1062 (23000): Duplicate entry '1' for key 'user.PRIMARY'

#id的1 重复了

mysql> insert into user values(2,'qq');

mysql> select * from user;
+----+------+
| id | name |
+----+------+
|  1 | qq   |
|  2 | qq   |
+----+------+
2 rows in set (0.00 sec)

mysql> insert into user values(NULL,'qq');
ERROR 1048 (23000): Column 'id' cannot be null



#1.联合主键---------------------
只要被约束的加起来 不重复就可以

create table user2(
	id int,
	name varchar(20),
	password varchar(20),
	primary key (id,name)
);

insert into user2 values(1,'ww','123');
insert into user2 values(2,'ww','123');-----v
insert into user2 values(2,'ww','123');-----x
insert into user2 values(1,'qq','123');-----v
insert into user2 values(NULL,'qq','123');-----x

mysql> select * from user2;
+----+------+----------+
| id | name | password |
+----+------+----------+
|  1 | qq   | 123      |
|  1 | ww   | 123      |
|  2 | ww   | 123      |
+----+------+----------+
3 rows in set (0.00 sec)




----------------------自增约束---------------------
auto_increment

create table user3(
	id int primary key auto_increment,
	name varchar(20)
);
create table user4(
	id int,
	name varchar(20)
);


insert into user3 (name) values('rr');
insert into user3 (name) values('tt');
insert into user3 (name) values('tt');
insert into user3 (name) values('fffr');

对于 id这一数据 自动管控 即便name相同 也会自动增加




#2.添加。删除 修改
alter table user4 add primary key(id);
alter table user4 drop primary key;
alter table user4 modify id int primary key;


----------------------外键约束---------------------
----------------------唯一约束---------------------
----------------------非空约束---------------------
----------------------默认约束---------------------






Last login: Thu Oct 22 22:22:39 on ttys000
liuxinny@ChristinadeMacBook-Pro ~ % mysql -uroot -pszlxy575757 
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.22 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> 
mysql> 
mysql> 
mysql> 
mysql> 
mysql> 
mysql> 
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| test               |
+--------------------+
5 rows in set (0.05 sec)

mysql> use test
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| pet            |
+----------------+
1 row in set (0.00 sec)

mysql> create table user(
	-> id int primary key,
	-> name varchar(20)
	-> );
Query OK, 0 rows affected (0.04 sec)

mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| pet            |
| user           |
+----------------+
2 rows in set (0.01 sec)

mysql> describe user;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   | PRI | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.01 sec)

mysql> 



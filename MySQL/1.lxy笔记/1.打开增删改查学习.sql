
数据库mysql学习1





1.Oracle ：开源，贵
2.SQL server ： 微软 仅win 不开放 
3.MySQL ： web应用上最好
4.Access ： 微软 小型 好 但！ 仅100人 存放的很小
5.DB2 ： 命令多 
6.PostgreSQL ： 最强大自由软件数据库管理 免费 开源



MySQL：
MySQL 适合中小型软件，MySQL 是一个真正的多用户、 多线程 SQL 数据库服务器。它能够快速、有效和安全的处理大量的数据。相对于 Oracle 等数据库来说，MySQL 的使用是非常简单的。MySQL 主要目标是快速、健壮和易用。

Web 网站开发者是 MySQL 最大的客户群，也是 MySQL 发展史上最为重要的支撑力量。



SQL（Structured Query Language，结构化查询语言）是用来操作关系型数据库的语言，使用 SQL 可以对数据库和表进行添加、删除、修改和查询等操作。



进入：
mysql -u root -p szlxy575757


mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.03 sec)




mysql> select * from admin;
ERROR 1046 (3D000): No database selected



INSERT INTO pet
VALUES ('Piffball','Dan','hamer','f','2020-10-10',NULL);

insert into pet
values('with','Query','rows','d','2001-1-1',NULL);
insert into pet
values('end','','c','d','2001-1-1',NULL);
insert into pet
values('database','b','c','d','2001-1-1',NULL);
insert into pet
values('console','b','c','d','2001-1-1',NULL);
insert into pet
values('values','b','c','d','2001-1-1',NULL);
insert into pet
values('trademark','b','c','d','2001-1-1',NULL);



INSERT INTO pet 
VALUES('kk1','cc1','dog1','1','1998-1-2',null);
INSERT INTO pet 
VALUES('Query','with','end','1','2007-03-03',null);
INSERT INTO pet 
VALUES('affiliates','sys','databases','1','1998-1-2',null);
INSERT INTO pet 
VALUES('console','values','birth','1','1998-1-2',null);
INSERT INTO pet 
VALUES('password','owners','integer','1','1998-1-2',null);





数据类型：
integer date char


--------------------------------------------------------
第一次 终端运行
--------------------------------------------------------
Last login: Thu Oct 22 22:18:43 on console
liuxinny@ChristinadeMacBook-Pro ~ % mysql -uroot -pszlxy575757
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.22 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)

mysql> create database test;
Query OK, 1 row affected (0.00 sec)

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
5 rows in set (0.00 sec)

mysql> use test;
Database changed
mysql> show tables;
Empty set (0.00 sec)

mysql> CREATE TABLE pet(
    -> name VARCHAR(20),
    -> owner VARCHAR(20),
    -> species VARCHAR(20),
    -> sex CHAR(1),
    -> birth DATE,
    -> death DATE);
mysql> CREATE TABLE pet(
name VARCHAR(20),
owner VARCHAR(20),
species VARCHAR(20),
sex CHAR(1),
birth DATE,
death DATE);
Query OK, 0 rows affected (0.01 sec)

mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| pet            |
+----------------+
1 row in set (0.00 sec)

mysql> describe pet;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| name    | varchar(20) | YES  |     | NULL    |       |
| owner   | varchar(20) | YES  |     | NULL    |       |
| species | varchar(20) | YES  |     | NULL    |       |
| sex     | char(1)     | YES  |     | NULL    |       |
| birth   | date        | YES  |     | NULL    |       |
| death   | date        | YES  |     | NULL    |       |
+---------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> select * from pet;
Empty set (0.00 sec)

mysql> INSERT INTO pet
    -> VALUES ('Piffball','Dan','hamer','f','2020-10-10',NULL);

mysql> INSERT INTO pet
VALUES ('Piffball','Dan','hamer','f','2020-10-10',NULL);
mysql> 
INSERT INTO pet VALUES ('Piffball','Dan','hamer','f','2020-10-10',NULL);
INSERT INTO pet VALUES ('Piffball','Dan','hamer','f','2020-10-10',NULL);
insert into pet values ('Pwrwerw','que','hen','4','2000-2-2','3000-3-3');
Query OK, 1 row affected (0.00 sec)

mysql> select * from pet;
+----------+-------+---------+------+------------+-------+
| name     | owner | species | sex  | birth      | death |
+----------+-------+---------+------+------------+-------+
| Piffball | Dan   | hamer   | f    | 2020-10-10 | NULL  |
+----------+-------+---------+------+------------+-------+
1 row in set (0.00 sec)

mysql> 
insert into pet
values('a','b','c','d','e','f');
ERROR 1292 (22007): Incorrect date value: 'e' for column 'birth' at row 1
mysql> 
insert into pet values('a','b','c','d','2001-1-1',NULL);
Query OK, 1 row affected (0.01 sec)

mysql> select * from pet;
+----------+-------+---------+------+------------+-------+
| name     | owner | species | sex  | birth      | death |
+----------+-------+---------+------+------------+-------+
| Piffball | Dan   | hamer   | f    | 2020-10-10 | NULL  |
| a        | b     | c       | d    | 2001-01-01 | NULL  |
+----------+-------+---------+------+------------+-------+
2 rows in set (0.00 sec)

mysql> 

--------------------------------------------------------
结束
--------------------------------------------------------



insert into pet
values('aaaaa','bbbbb','ccccc','e','2000-1-1','3000-1-1');

delete from pet where name='a';

update pet set name='end' where owner='b';

select 查询






--------------------------------------------------------
第2次 终端运行
--------------------------------------------------------

mysql> delete from pet where name='kk1';
Query OK, 2 rows affected (0.00 sec)

mysql> select * from pet;
+------------+--------+-----------+------+------------+-------+
| name       | owner  | species   | sex  | birth      | death |
+------------+--------+-----------+------+------------+-------+
| Piffball   | Dan    | hamer     | f    | 2020-10-10 | NULL  |
| Query      | with   | end       | 1    | 2007-03-03 | NULL  |
| affiliates | sys    | databases | 1    | 1998-01-02 | NULL  |
| console    | values | birth     | 1    | 1998-01-02 | NULL  |
| password   | owners | integer   | 1    | 1998-01-02 | NULL  |
+------------+--------+-----------+------+------------+-------+
5 rows in set (0.00 sec)

mysql> update pet set name='password' where owner='sys';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from pet;
+----------+--------+-----------+------+------------+-------+
| name     | owner  | species   | sex  | birth      | death |
+----------+--------+-----------+------+------------+-------+
| Piffball | Dan    | hamer     | f    | 2020-10-10 | NULL  |
| Query    | with   | end       | 1    | 2007-03-03 | NULL  |
| password | sys    | databases | 1    | 1998-01-02 | NULL  |
| console  | values | birth     | 1    | 1998-01-02 | NULL  |
| password | owners | integer   | 1    | 1998-01-02 | NULL  |
+----------+--------+-----------+------+------------+-------+
5 rows in set (0.00 sec)

mysql> update pet set name='a' where owner='sys';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from pet;
+----------+--------+-----------+------+------------+-------+
| name     | owner  | species   | sex  | birth      | death |
+----------+--------+-----------+------+------------+-------+
| Piffball | Dan    | hamer     | f    | 2020-10-10 | NULL  |
| Query    | with   | end       | 1    | 2007-03-03 | NULL  |
| a        | sys    | databases | 1    | 1998-01-02 | NULL  |
| console  | values | birth     | 1    | 1998-01-02 | NULL  |
| password | owners | integer   | 1    | 1998-01-02 | NULL  |
+----------+--------+-----------+------+------------+-------+
5 rows in set (0.00 sec)

mysql> 



--------------------------------------------------------
结束
--------------------------------------------------------




















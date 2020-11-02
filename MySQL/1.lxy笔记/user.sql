






insert into user1
values()


insert into user1 values(22222,'ww',5);
insert into user1 values(33,'SSSSeeeerrr',4);
insert into user1 values(0,'ddd',99999);
insert into user1 values(3456,'pppqweqxsx',890);



-----------------------user2主键约束-----------


create table user2(
	id int primary key,
	name varchar(20)
);

insert user2 values(12,'ww');
insert user2 values(55,'qq');
insert user2 values(34,'dd');

select * from user2;
+----+------+
| id | name |
+----+------+
| 12 | ww   |
| 34 | dd   |
| 55 | qq   |
+----+------+



insert user2 values(34,'zzz');
ERROR 1062 (23000): Duplicate entry '34' for key 'user2.PRIMARY'

insert user2 values(5,'dd');
insert user2 values(3,'dd');
insert user2 values(4,'dd');



 desc user2;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   | PRI | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

select * from user2;
+----+------+
| id | name |
+----+------+
|  3 | dd   |
|  4 | dd   |
|  5 | dd   |
| 34 | dd   |
| 55 | qq   |
+----+------+


delete from user2 where id = 3;

update user2 set name='www' where id=5;

select * from user2;
+----+------+
| id | name |
+----+------+
|  4 | dd   |
|  5 | www  |
| 34 | dd   |
| 55 | qq   |
+----+------+





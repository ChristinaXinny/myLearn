
---------------------基本-----------------------

软件项目的开发周期，如下：
需求分析
概要设计
逻辑设计/详细设计
代码编写
软件测试
安装部署


MySQL 的数据类型有大概可以分为 5 种，分别是整数类型、浮点数类型和定点数类型、日期和时间类型、字符串类型、二进制类型等。
注意：整数类型和浮点数类型可以统称为数值数据类型。


1) 数值类型

整数类型包括 TINYINT、SMALLINT、MEDIUMINT、INT、BIGINT，
tinyint   smallint  mediumint  int.  bigint 
浮点数类型包括 FLOAT 和 DOUBLE，
float.  double 
定点数类型为 DECIMAL。
decimal 

2) 日期/时间类型
包括 YEAR、TIME、DATE、DATETIME 和 TIMESTAMP。
year  time.  date.   datetime.  timestamp 
3) 字符串类型
包括 CHAR、VARCHAR、BINARY、VARBINARY、BLOB、TEXT、ENUM 和 SET 等。
char varchar binary varbinary  blob.  text.  enum.  set 
4) 二进制类型
包括 BIT、BINARY、VARBINARY、TINYBLOB、BLOB、MEDIUMBLOB 和 LONGBLOB。
bit  binary.  varbinary.  tinyblob.   blob.  mwdiumblob 


--进入：
---------------------库操作-----------------------
mysql -uroot -pqwe123123


--查看数据库databases；
show databases;

--在数据库服务器中创建数据库? 
create database databaseName;

-- 修改
alter database databaseName;

-- 删除
drop database databaseName;

--选择数据库? 
use databasesName;


--查看该数据库中有哪些表? 
show tables;




--------------------------表-

--创建一个表? 创建一个pet表
create TABLE pet(
name VARCHAR(20),
owner VARCHAR(20),
specise VARCHAR(20),
sex CHAR(1),
brith DATAE,
death DATE );


--查询表中的数据? 
select * from tableName;

--查看数据表的架构? 
describe tableName;
desc tableName;


--表中插入数据?
INSERT INTO pet
VALUES('kk','cc','dog','1','1998-8-2',null);

insert into pet
values('qq','ww','ee','1','1111-11-11','2222-2-22');

INSERT INTO pet(name,owner) VALUES ('xx','cc');


--删除语句:
DELETE FROM tablesName WHRER 条件;
delete from pet where name='a';
delete from pet where name='a';

--改
update pet set name='end' where owner='b';

--select 查询
select * from pet;






---------------------约束-----------------------

create database yueshu;
use yueshu






---主键约束-----------PRI
唯一确定一张表的一条元素
给某个字段加约束 -》 字段不能重复 不能为空

create table user1(
id int primary key,
name varchar(20)
);



	
#1.联合主键
联合的主键加起来不重复就可以 
联合主键任何一个字段都不可位空
create table user2(
	id int,
	name varchar(20),
	password varchar(20),
	primary key (id,name)
);



#2.自增约束
#auto_increment
create table user3(
	id int primary key auto_increment,
	name varchar(20)
);

create table tb_student2 (
id int NOT NULL auto_increment,
name varchar(20) NOT NULL,
primary key(ID)
)auto_increment=100;//从100开始加

create table user3(
id int primary key auto_increment,
name varchar(20)
);


#2.添加。删除 修改
alter table user4 add primary key(id);//添加
alter table user4 drop primary key;//删除
alter table user4 modify id int primary key;//修改


---唯一约束------UNI
修饰字段的值不可重复

alter table user4 add unique(name);


create table user67(
id int,
name varchar(20),
age int,
unique(age,name)
);
//这种形式写 就变成了age和name两个何在一起 不重复就ok了

#删除
alter table user4 drop index name;

#添加
alter table user4 modify name varchar(20) unique;



总结：
1.建立table就添加约束
2.可以使用alter 。。。add。。。。
3.可以使用 alter。。。modif。。。
4.删除 alter。。。drop。。。。


---非空约束

修饰字段不可为空



---主键约束
---主键约束











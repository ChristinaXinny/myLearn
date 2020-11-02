

查询

三。模糊查询
like,  between and,  in,  is null|is not null
	
	
1. like
#1查询last_name含‘a’
select * 
from employees 
where last_name like '%a%';
#2查询第三个字符为‘v’ 第五个为‘e'
select *
from employees
where last_name like '__v_e%';
#3查询第二个为'_'的
select *
from
	employees
where
	last_name like '_\_%';
	

2.between and
注意：
	包含2个数字
	两个临界值不要换顺序 小～大
	
#1.查询100～120
select *
from
	employees
where
	employee_id >= 100 and employee_id <=120;
---------------
select *
from
	employees
where
	employee_id BETWEEN 100 AND 120;	
	
	
	
3.in
#查询编号。IT_PROG    AD_VP   AD_PRES
select last_name , job_id
from employees
where job_id = 'IT_PROG' or job_id = 'AD_VP' or job_id = 'AD_PRES';
---------------
select last_name , job_id
from employees
where job_id in ( 'IT_PROG' , 'AD_VP' ,'AD_PRES'); 


4.is
#查询没有奖金的
select last_name, commission_pct
from employees
where commission_pct is NULL;

select last_name,commission_pct
from employees
where commission_pct is not NULL;





5.<=> 安全等于
select last_name, salary
from employees
where salary <=> NULL;


select last_name, salary
from employees
where salary <=> 12000;


is null & <=>
IS NULL :: 仅仅判断NULL值 可读性高




查询工号为176 姓名与 （年薪=salary*12*(1+commission_pct)）
SELECT
	last_name,
	department_id,
	salary * 12 * ( 1+ ifnull( commission_pct, 0 ) ) AS 年薪 
FROM
	employees;
	
	ifnull( commission_pct, 0 ) commission_pct为0 则返回0
	
	
	
	
	
	
	
	一、查询没有奖金,且工资小于18000的salary ,last_name
	SELECT
		salary,
		last_name 
	FROM
		employees 
	WHERE
		commission_pct IS NULL 
		AND salary < 18000;
		
		
	
	二、查询employees 表中,job_id不为‘IT’或者工资为12000的员工信息
	SELECT
		* 
	FROM
		employees 
	WHERE
		job_id <> 'IT' 
		OR salary = 12000;
	
	
#	三、查询那些位置编号
	select distinct location_id
	from departments;
	
	
	
	
#	面试题
	select * from employees;
	select * from employees where commission_pct like '%%' and last_name like '%%';
	
	两者不同  如果判断有null的时候【下面like的没有null 第一条有null
	如果是该为or 加所有的条件 就一样了
	select * from employees where commission_pct like '%%' or last_name like '%%' or...;
	
	
	
查询
1.查字段。select 字段名 from 表名
2.多个字段 select 字段名，字段名 from 表名
3.所有 select * from 表名
4.常量 select 100
5.函数 select 函数名字（实惨）
6.表达式【简单+-*/% 不可以++ --】
7.起别名【as/空格】
8.去重 select distinct 字段 from 表
		select distinct 字段，字段 from 表【x】
9. + 
	数值 + 数值     运算
	字符 + 数值。   字符变数值 失败为0。 在运算
	null + 值。    null
	
10.concat函数 拼接字符。 
	select concat(employee_id ,job_id) from employees;
	
11.ifnull函数  判断字段/表达式是否为null 是null：返回指定值。否则返回原本值
select ifnull(commission_pct,0), commission_pct from employees;

12.isnull函数  判断字段/表达式是否null。 是1。否0  
select isnull(commission_pct),commission_pct from employees;


 列表可以是字段	、常量、表达式、函数 可以是多个
结果是一个虚拟的表


select 字段名 from 表名
select 字段名，字段名 from 表名
select * from 表名

字符型和日期型要用‘’
数值型不用



查询条件分类：
1.简单条件
> < = <=> != >= <=
2.逻辑
&& and
|| or
! not
3.模糊查询
like: 可以判断字符型/数值型
	select * from employees where  department_id like '1__';
	select * from employees where  department_id like '1%';
	'_'：任意单个字符   '%'：任意多个字符
	
BETWEEN and :
 







排序查询：
可以支持单个字段 多个字段 表达式 函数 别名
order by一般放在查询语句的最后 但！ limit子句除外 limit才是真正的最后

语法：
select 查询列表
from 表
where 筛选
order by 排序列表 【 asc|desc 】【生序｜降序。不写默认为asc】

#案例1:查询员工信息,要求工资从高到低排序
SELECT FROM employees ORDER BY salary DESC ;
SELECT FROM employees ORDER BY salary;
#案例2:查询部门编号>=90的员工信息,按入职时间的先后进行排序【添加筛选条件】
SELECT * 
FROM employees
WHERE department_id >=90
ORDER BY hiredate ASC ;

 
#案例3:按年薪的高低显示员工的信息和年薪【按表达式排序】
SELECT * ,salary *12*(1+IFNULL( commission_pct ,0 )) 年薪
FROM employees
ORDER BY salary *12*(1+IFNULL( commission_pct ,0 )) DESC;
#案例4:按年薪的高低显示员工的信息和年薪【按别名排序】
SELECT * ,salary *12*(1+IFNULL( commission_pct ,0 )) 年薪
FROM employees
ORDER BY 年薪 DESC;



select length(last_name) 名字长度,last_name, salary
from employees
order by length(last_name) desc;


#多个字段排序
select * 
from employees
order by salary asc,employee_id desc;



--------------测试
#1.查询员工的姓名和部门号和年薪,按年薪降序按姓名升序
SELECT last_name ,department_id ,salary *12*( 1+IFNULL( commission_pct ,0 )) 年薪
FROM employees
ORDER BY 年薪 asc ,last_name desc



#2.选择工资不在8000到17000的员工的姓名和工资,按工资降序
select last_name, salary
from employees
where salary NOT between 8000 and 17000
order by salary desc;


#3.查询邮箱中包含e的员工信息,并先按邮箱的字节数降序,再按部门号升序
SELECT *, LENGTH( email ) 
FROM employees 
WHERE email LIKE '%e%' 
ORDER BY length( email ) DESC, department_id ASC;








常见函数 
#进阶4:常见函数

概念:类似于java的方法,将一组逻辑语句封装在方法体中,对外暴露方法名
好处:1、隐藏了实现细节 2、提高代码的重用性
调用:select 函数名(实参列表)【from表】
特点:
	①叫什么(函数名)
	②千什么(函数功能
分类:
	1、单行函数：给一个数据 返回一个数据 
		concat 、length 、ifnu11等
	2、分组函数：给一组数据 返回一个数据
		功能:做统计使用,又称为统计函数、聚合函数、组函数
字符函数
数学函数
日期函数
其他函数
流程控制函数

一。字符函数
length()
SELECT LENGTH('jooj');
-- ------>4
SELECT LENGTH('时尚色sss');
-- ------>12

show VARIABLES LIKE '%char%';
utf-8 汉字3个字符


#concat
#upper()
#lower()
SELECT UPPER('jone');
SELECT LOWER( 'JKOS');
姓大写 名小写 拼接
select concat(upper(last_name),'-',lower(first_name)) 姓名 
from employees;

substr(),substring()【从1开始】
select substr('厘米戳撒的发',3) out_put;
select substr('厘米戳撒的发',2,4) out_put;
 

instr()
select instr('qwerty','we')as ot;
---->2
select instr('qwerty','ss')as ot;
---->0


trim()
select length(trim('      ssss   ')) as po;
select trim('a' from 'aaaaQWEWDERFaaaaEFaaaa');

#lpad 用左填充
#rlad 右填充
select lpad('sss',12,'@') as op;
----->@@@@@@@@@sss
select rpad('sss',12,'Q') as op;
----->sssQQQQQQQQQ


replace()
select replace('ssssqqqqsswww','s','S');
------>SSSSqqqqSSwww



数学函数
round四舍五入
select round(-1.55);
select rount(1.34,4);

ceil 向上取整 返回>=改数的最小整数
select ceil(-1.02)---->-1
select ceil(1.02)---->2

floor 向下取整 返回<=该数字的最大整数
select floor(-9.99);

truncate 截断
select truncate(1.69999, 1);------1.6

mod取余-------mod(a,b) : a-a/b*b
mod(-10, -3) : -10 - (-10) / (-3) * (-3 )

select mod(10, -3);



日期函数






流程控制函数
if 
if。  else

select if(10<5,'da','xiao');



案例:查询员工的工资,要求
部门号=30,显示的工资为1.1倍
部门号=40,显示的工资为1.2倍
部门号=50,显示的工资为1.3倍
其他部门,显示的工资为原工资 

SELECT salary 原始工资, d epartment_id,
CASE department_id
WHEN 30 THEN salary *1.1
WHEN 40 THEN salary *1.2
WHEN 50 THEN salary *1.3
ELSE salary 
END AS 新工资
FROM employees;

 
sum求和、avg平均值、max最大值、min最小值、count 计算个数
sum
#1、简单的使用
SELECT SUM ( salary)FROM employees ;
SELECT AVG ( salary)FROM employees ;
SELECT MIN ( salary)FROM employees ;
SELECT MAX ( salary)FROM employees
SELECT COUNT ( salary)FROM employees


查有几行
select count(*) from employees;





#1.查询公司员工工资的最大值,最小值,平均值,总和
SELECT
	MAX( salary ) mx_sal,
	MIN( salary ) mi_sal,
	ROUND( AVG( salary ), 2 ) ag_sal,
	SUM( salary ) sm_sal 
FROM
	employees;
	
#2.查询员工表中的最大入职时间和最小入职时间的相差天数(DIFFRENCE )
SELECT
	DATEDIFF ( MAX( hiredate ), MIN( hiredate ) ) DIFFRENCE 
FROM
	employees;
#3.查询部门编号为90的员工个数
SELECT COUNT( *)
FROM employees;

---------------------------------------------
#进阶5:分组查询
语法:
select 分组函数,列(要求出现在group by 的后面
from 表
where 【筛选条件】
group by 分组的列表
order by 【子句】
注意:
查询列表必须特殊,要求是分组函数和group by 后出现的字段
 
简单的分组查询
#案例1:查询每个工种的最高工资
SELECT MAX( salary),job_id
FROM employees
GROUP BY job_id ;
#案例2:查询每个位置上的部门个数
SELECT COUNT( *)location_id
FROM departments
GROUP BY location_id ;

添加筛选条件
案例1:查询邮箱中包含a字符的,每个部门的平均工资
SELECT AVG ( salary),department_id
FROM employees
WHERE email LIKE '%a%'
GROUP BY department_id ;

查询最高工资
select MAX(salary),manager_id
from employees
where commission_pct is not null
GROUP by manager_id;








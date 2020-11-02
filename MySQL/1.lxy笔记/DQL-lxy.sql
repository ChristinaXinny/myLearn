

函数
1.length()

select length('hoho');
show variables like '%char%';		


2.concat()
select concat(last_name,'_',first_name) xin FROM employees

3.upper lower
select upper('hod');
select lower("WWWW");

4.substr  substring
select substr('SSSSSSSqqqqqqWWWWWW',14) ou;

select concat(upper(substr(last_name,1,1)),'_',lower(substr(last_name,2))) outpp
FROM employees;



select max(salary),job_id
FROM employees
group by job_id;


select count(*),location_id
FROM departments
group by location_id;


select avg(salary),department_id
FROM employees
where email like '%a%'
group by department_id;


select max(salary),manager_id
FROM employees
where commission_pct is not null
group by manager_id;




select count(*),department_id
FROM employees
group by department_id;



select count(*),department_id
FROM employees
group by department_id
having count(*)>2;


select max(salary),job_id
from employees
group by job_id

select max(salary),job_id
from employees
where commission_pct is not null
group by job_id
having max(salary)>12000


select min(salary),manager_id
from employees
where manager_id > 102
group by manager_id
having min(salary)>5000;



select avg(salary),department_id,job_id,
FROM employees
group by job_id, department_id;


select max(salary)-min(salary) dif
FROM employees;



select min(salary),manager_id
FROM employees
where manager_id is not null
group by manager_id
having min(salary)>6000;




select department_id,count(*),avg(salary)
FROM employees
group by count(*)
order by avg(salary) desc;



-------------------------------连接查询
等值连接
select * from beauty;

select * FROM boys;

select name, boyName 
from boys,beauty
where beauty.boyfriend_id = boys.id;



select last_name,department_name
FROM employees,departments
where employees.department_id = departments.department_id;



select last_name,department_name
FROM employees e, departments d
where e.commission_pct is not null
and e.department_id = d.department_id;


SELECT
	last_name,
	department_name,
	commission_pct 
FROM
	employees e,
	departments d 
WHERE
	e.department_id = d.department_id 
	AND e.commission_pct IS NOT NULL;
	
	
	
	
非等值连接	
select salary,grade_level
FROM employees e, job_grades g
where  salary between g.lowest_sal and g.highest_sal;



自连接
SELECT e.employee_id, e.last_name, m.employee_id, m.last_name
from employees e, employees m
where e.manager_id = m.employee_id;


------------------------------测试题
SELECT
	MAX( salary ),
	AVG( salary ) 
FROM
	employees;
	
	

SELECT
	employee_id,
	job_id,
	last_name 
FROM
	employees 
ORDER BY
	department_id ASC,
	salary DESC;



SELECT
	job_id 
FROM
	employees 
WHERE
	job_id LIKE '%a%e%';




SELECT
	s.NAME,
	grade.NAME,
	result.score 
FROM
	student s,
	grade g,
	result r 
WHERE
	s.gradeId = g.id 
	AND s.id = r.studentNo;
	
	
	
select last_name, d.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;
	
	
	
select job_id, location_id
FROM employees e, departments d
where e.department_id = d.department_id
and e.department_id = 90;
	
	
	


select last_name, department_name, location_id, city
FROM employees e, departments d, locations l
where e.department_id = d.department_id
and l.location_id = d.location_id
and e.commission_pct is not null;


select last_name, d.department_id, l.location_id, city
FROM employees e, departments d, locations l
where e.department_id = d.department_id
and l.location_id = d.location_id
and city = 'Toronto';




SELECT department_name, job_title, min(salary)
from employees e, departments d, jobs j
where e.department_id = d.department_id
AND e.job_id = j.job_id
GROUP BY department_name,job_title;





SELECT country_id ,COUNT(*) bum
FROM departments d, locations l
where d.location_id = l.location_id
GROUP BY country_id
HAVING bum > 2;





SELECT e.last_name employees, e.employee_id "Emp#", m.last_name manager, m.employee_id "Mgr#"
FROM employees e, employees m
WHERE e.manager_id = m.employee_id
AND e.last_name = 'kochhar';





------------------------------左外连接
SELECT b.*,bo.*
FROM boys bo
LEFT OUTER JOIN beauty b
ON b.boyfriend_id = bo.id
WHERE b.id IS NULL;


------------------------------子查询
SELECT job_id
FROM employees
WHERE employee_id = 141;

SELECT salary
FROM employees
WHERE employee_id = 143;


SELECT last_name, job_id, salary
FROM employees 
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
)AND salary>(
		SELECT salary
		FROM employees
		WHERE employee_id = 143
);


SELECT last_name, job_id, salary
FROM employees
WHERE salary = (
	SELECT MIN(salary)
	FROM employees
);



SELECT ag_dep.*, g.grade_level
FROM (
	SELECT AVG(salary) ag, department_id
	FROM employees
	GROUP BY department_id
)ag_dep
INNER JOIN job_grades g
ON ag_dep.ag BETWEEN lowest_sal AND highest_sal;













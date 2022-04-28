create table employee(emp_code varchar(250) PRIMARY KEY, emp_name varchar(250));

create table department(dept_code varchar(250) PRIMARY KEY, dept_name varchar(250), emp_code varchar(250), FOREIGN KEY(emp_code) REFERENCES employee(emp_code));

create table project(proj_code varchar(250) PRIMARY KEY, proj_name varchar(250));

create table proj_dept(proj_code varchar(250) NOT NULL, FOREIGN KEY(proj_code) REFERENCES project(proj_code),
                       	dept_code varchar(250) NOT NULL, FOREIGN KEY(dept_code) REFERENCES department(dept_code)
                       	);
Alter table proj_dept
Add constraint PK_proj_dept
primary key (proj_code, dept_code);

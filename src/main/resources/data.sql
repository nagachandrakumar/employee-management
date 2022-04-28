insert into employee values('E10001', 'Ram');
insert into employee values('E10002', 'Raj');
insert into employee values('E10003', 'Rahul');

insert into department values('D101', 'IT', 'E10001');
insert into department values('D102', 'Sales', 'E10002');
insert into department values('D103', 'Finance', 'E10002');

insert into project values('P1001', 'D1BAU');
insert into project values('P1003', 'D2BAU');
insert into project values('P1002', 'D2testing');
insert into project values('P1004', 'D3testing');

insert into proj_dept values('P1001', 'D101');
insert into proj_dept values('P1001', 'D102');
insert into proj_dept values('P1003', 'D102');
insert into proj_dept values('P1002', 'D102');
insert into proj_dept values('P1004', 'D103');
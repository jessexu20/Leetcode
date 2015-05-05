--Exercise 5.1--
Create table student (snum int, sname varchar(20),major varchar(20), level varchar(20),age int);
create table class (name varchar(20),meets_at time, room varchar(20), fid int);
Create table enrolled(snum int,cname varchar(20));
create table faculty(fid int,fname varchar(20),deptid int);
Insert into student values (1,'Jesse','CS','GR',23);
Insert into student values (2,'Jesse','EE','JR',18);
Insert into student values (3,'Tom','CHE','SR',18);
Insert into student values (4,'Alex','CS','GR',25);
Insert into student values (5,'Tim','BIO','JR',18);
Insert into student values (6,'Gray','PH','GR',19);
Insert into student values (7,'Alex','MA','GR',23);
Insert into student values (8,'Jackie','History','GR',23);
insert into class values('CS505','9:00:00','R128',2);
insert into class values('CS506','10:00:00','R128',3);
insert into class values('CS507','9:00:00','R129',1);
insert into class values('CS508','10:00:00','R130',1);
insert into enrolled values(1,'CS505');
insert into enrolled values(3,'CS505');
insert into enrolled values(4,'CS505');
insert into enrolled values(1,'CS506');
insert into enrolled values(5,'CS507');
insert into enrolled values(6,'CS508');
insert into enrolled values(2,'CS505');
insert into enrolled values(6,'CS505');
insert into enrolled values(8,'CS505');
insert into faculty values(1,'I.Teach',1);
insert into faculty values(2,'II.Teach',2);
insert into faculty values(3,'III.Teach',1);
--1--
select distinct s.sname from student s, class c, enrolled e,faculty f
where s.snum=e.snum and e.cname=c.name and c.fid=f.fid and f.fname="I.Teach" and s.level='JR';
--2--
select MAX(s.age) from student s, class c, enrolled e,faculty f
where s.major='History' or (s.snum=e.snum and e.cname=c.name and c.fid=f.fid and f.fname="I.Teach");
--3--
select distinct c.name from class c
where c.room='R128'
union
select distinct c.name from class c
where (select count(*) from enrolled e where e.cname=c.name) >5;
--4--
select distinct s.sname from student s, class c1,class c2, enrolled e
where  c1.meets_at =c2.meets_at and c1.name<>c2.name and s.snum=e.snum and e.cname=c1.name;
--5--
select distinct f.fname from faculty f,class c1,class c2
where c1.room=c2.room and c1.fid=f.fid and c1.name<>c2.name;
--6--
select distinct f1.fname,f2.fname from faculty f1, faculty f2
where  exist ((select count(*) from enrolled e,class c where f1.fid=c.fid and e.cname=c.name)
+(select count(*) from enrolled e,class c where f2.fid=c.fid and e.cname=c.name)<5 and f1.fname<>f2.fname);
--7--
select s.level, AVG(s.age) from student s
group by s.level;
--8--
select s.level, AVG(S.age) from student s
where s.level<>'JR'
group by s.level;
--9--
select distinct s.sname,max(t.countS) from 
(select snum, count(cname) as countS from enrolled group by snum) as t, student s 
where t.snum=s.snum;
--10--
select s.sname from student s where not exists (select e.snum from enrolled e where e.snum=s.snum);
--11--
select t.age,max(t.L) from 
(select age,level,count(snum) as L from student s group by age,level) as t 
group by age;
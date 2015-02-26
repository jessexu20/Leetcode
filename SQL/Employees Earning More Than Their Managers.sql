CREATE TABLE Employee(Id int,Name  char(20), Salary int,ManagerId int);
INSERT INTO Employee(Id, Name ,Salary , ManagerId) VALUES (1,'Joe',70000,3);
INSERT INTO Employee(Id, Name ,Salary , ManagerId) VALUES (2,'Henry',80000,4);
INSERT INTO Employee(Id, Name ,Salary , ManagerId) VALUES (3,'Sam',60000,NULL);
INSERT INTO Employee(Id, Name ,Salary , ManagerId) VALUES (4,'Max',90000,NULL);
SELECT e1.Name FROM Employee e1, Employee e2 WHERE e1.ManagerId = e2.Id AND e1.Salary> e2.Salary;
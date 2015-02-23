CREATE TABLE Person(PersonId integer PRIMARY KEY, FirstName char(20),LastName char(20));
CREATE TABLE Address(AddressId integer PRIMARY KEY, PersonId integer, City char(20),State char(20));
INSERT INTO Person (PersonId, FirstName,LastName) VALUES (1,'Jesse','XU');
INSERT INTO Person (PersonId, FirstName,LastName) VALUES (2,'jack','zhang');
INSERT INTO Person (PersonId, FirstName,LastName) VALUES (3,'amy','zhang');
INSERT INTO Person (PersonId, FirstName,LastName) VALUES (4,'linda','wang');

INSERT INTO Address (AddressId, PersonId, City,State) VALUES(1,1,'SHANGHAI','NA');
INSERT INTO Address (AddressId, PersonId, City,State) VALUES(2,2,'RALEIGH','NC');
INSERT INTO Address (AddressId, PersonId, City,State) VALUES(3,3,'BOSTON','MA');
INSERT INTO Address (AddressId, PersonId, City,State) VALUES(4,3,'NEW YORK','NY');
SELECT FirstName, LastName, City, State FROM Person LEFT JOIN Address ON Person.PersonId=Address.PersonId;

SELECT MAX(Salary) FROM Employee WHERE Salary<>(SELECT MAX(Salary) FROM Employee);

CREATE TABLE Employee(Id integer PRIMARY KEY,Salary integer);
INSERT INTO Employee(Id, Salary) VALUES (1,100);
INSERT INTO Employee(Id, Salary) VALUES (2,200);
INSERT INTO Employee(Id, Salary) VALUES (3,300);
-- INSERT INTO Employee(Id, Salary) VALUES (4,300);
-- INSERT INTO Employee(Id, Salary) VALUES (5,300);

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE M INT;
    SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
       SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1
  );
END
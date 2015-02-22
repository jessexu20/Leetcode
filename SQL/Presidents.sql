CREATE TABLE Presidents(firstName char(10), lastName char(10), beginTerm integer, endTerm integer);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('George W.','Bush',2000,2004);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('George H.W.','Bush',1996,2000);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('B.','Obama',1899,1904);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('Hilary','Cliton',1905,1910);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('George','Cliton',1967,1969);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('One','efef',1894,1895);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('Grover','Cleveland',1888,1893);
INSERT INTO Presidents(firstName, lastName, beginTerm, endTerm) VALUES('Grover','Cleveland',1957,1961);
SELECT firstName,lastName FROM Presidents WHERE beginTerm <= 1900 AND endTerm>=1900;
SELECT firstName,lastName FROM Presidents WHERE endTerm=beginTerm;
SELECT COUNT(*) FROM Presidents WHERE endTerm-beginTerm>4;
SELECT DISTINCT lastName FROM Presidents p1 WHERE EXISTS (SELECT * FROM Presidents p2 WHERE p1.lastName=p2.lastName AND p1.firstName <> p2.firstName);
SELECT AVG(endTerm-beginTerm) AS avgYear FROM Presidents WHERE beginTerm>1900;
SELECT p2.firstName,p2.lastName FROM Presidents p1,Presidents p2,Presidents p3 WHERE p1.firstName='Grover' AND p1.lastName='Cleveland' 
AND p3.firstName='Grover' AND p3.lastName='Cleveland' AND p2.beginTerm>= p1.endTerm AND p2.endTerm<=p3.beginTerm AND p1.firstName<>p2.firstName
AND p1.lastName<>p2.lastName;
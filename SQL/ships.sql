CREATE TABLE Ships(name char(20), yearLaunched integer, country char(20), numGuns integer, gunSize integer, displacement integer);
INSERT INTO Ships (name, yearLaunched, country, numGuns, gunSize, displacement) VALUES ('New Jersey', 1943, 'USA', 9, 16, 46000);
INSERT INTO Ships (name, yearLaunched, country, numGuns, gunSize, displacement) VALUES ('NC', 1929, 'USA', 4,         16, 46000);
INSERT INTO Ships (name, yearLaunched, country, numGuns, gunSize, displacement) VALUES ('SC', 1882, 'USA', 5,         20, 90909);
INSERT INTO Ships (name, yearLaunched, country, numGuns, gunSize, displacement) VALUES ('New YORK', 1953, 'USA',  10, 19, 4000);
INSERT INTO Ships (name, yearLaunched, country, numGuns, gunSize, displacement) VALUES ('New', 1923, 'JAPAN', 2,      30, 20000);
SELECT name,country,numGuns FROM Ships WHERE gunSize=16 AND yearLaunched<1930;
SELECT * FROM Ships WHERE gunSize>=ALL(SELECT gunSize FROM Ships);
SELECT name,gunSize FROM Ships WHERE gunSize =(SELECT MAX(gunSize) FROM Ships WHERE gunSize < (SELECT MAX(gunSize) FROM Ships));
SELECT country,AVG(numGuns) AS avgGuns FROM Ships GROUP BY country;
CREATE TABLE Battles(ship char(20), battleName char(20), result char(20));
INSERT INTO Battles(ship, battleName, result) VALUES ('SC', 'North Atlantic', 'sunk');
INSERT INTO Battles(ship, battleName, result) VALUES ('New YORK', 'North Atlantic', 'sunk');
INSERT INTO Battles(ship, battleName, result) VALUES ('New', 'North Atlantic', 'sunk');
SELECT DISTINCT s1.country, s2.country FROM Ships s1,Ships s2,Battles b1,Battles b2 WHERE s1.name=b1.ship AND s2.name=b2.ship AND b1.battleName=b2.battleName AND s1.country<s2.country;
SELECT country,COUNT(*) AS numSunk FROM Ships,Battles WHERE Ships.name= Battles.ship AND battleName= 'Surigao Strait' AND result='sunk' GROUP BY country 
UNION
SELECT DISTINCT country,0 AS numSunk FROM Ships sh WHERE sh.name IN (SELECT ship FROM Battles WHERE battleName='Surigao Strait') AND NOT EXISTS
 (SELECT * FROM Ships,Battles WHERE country=sh.country AND Ships.name=Battles.ship AND battleName='Surigao Strait' AND result='sunk')

create table R(x char(1), y char(1));
	 INSERT INTO R(x,y) VALUES(NULL,NULL);
SELECT r1.x, r2.y FROM R r1, R r2 WHERE r1.y = r2.x
CREATE TABLE game(team char(20), day char(20),opponent char(20),runs integer);
INSERT INTO game (team,day,opponent,runs) VALUES ('Dragons','Sunday','Swallows','4');
INSERT INTO game (team,day,opponent,runs) VALUES('Tigers'	,'Sunday',	'Bay Stars'	,'9');
INSERT INTO game (team,day,opponent,runs) VALUES('Carp',	'Sunday',	NULL	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Swallows'	,'Sunday',	'Dragons',	'7');
INSERT INTO game (team,day,opponent,runs) VALUES('Bay Stars',	'Sunday'	,'Tigers',	'2');
INSERT INTO game (team,day,opponent,runs) VALUES('Giants'	,'Sunday',	NULL	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Dragons'	,'Monday'	,'Carp'	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Tigers',	'Monday'	,NULL	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Carp'	,'Monday'	,'Dragons'	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Swallows'	,'Monday'	,'Giants'	,'0');
INSERT INTO game (team,day,opponent,runs) VALUES('Bay Stars',	'Monday',	NULL	,NULL);
INSERT INTO game (team,day,opponent,runs) VALUES('Giants',	'Monday'	,'Swallows'	,'5');

SELECT COUNT(*), COUNT(Runs) FROM game WHERE team = 'Tigers';//2,1

SELECT COUNT(*), COUNT(Runs) FROM game WHERE team = 'Carp';//2,0
SELECT COUNT(*), COUNT(Runs) FROM game WHERE team = 'Swallows';//2,2

SELECT team, day FROM game WHERE opponent IS NULL OR NOT (runs >= 0);
TEAM		     DAY
-------------------- --------------------
Carp		     Sunday
Giants		     Sunday
Tigers		     Monday
Bay Stars	     Monday


CREATE TABLE score(team char(20), day char(20),opponent char(20),runs integer);
INSERT INTO score (team,day,opponent,runs) VALUES ('Dragons','Sunday','Swallows','4');
INSERT INTO score (team,day,opponent,runs) VALUES('Tigers'	,'Sunday',	'Bay Stars'	,'9');
INSERT INTO score (team,day,opponent,runs) VALUES('Carp',	'Sunday',	'Giants'	,'2');
INSERT INTO score (team,day,opponent,runs) VALUES('Swallows'	,'Sunday',	'Dragons',	'7');
INSERT INTO score (team,day,opponent,runs) VALUES('Bay Stars',	'Sunday'	,'Tigers',	'2');
INSERT INTO score (team,day,opponent,runs) VALUES('Giants'	,'Sunday',	'Carp'	,'4');
INSERT INTO score (team,day,opponent,runs) VALUES('Dragons'	,'Monday'	,'Carp'	,'6');
INSERT INTO score (team,day,opponent,runs) VALUES('Tigers',	'Monday'	,'Bay Stars'	,'5');
INSERT INTO score (team,day,opponent,runs) VALUES('Carp'	,'Monday'	,'Dragons'	,'3');
INSERT INTO score (team,day,opponent,runs) VALUES('Swallows'	,'Monday'	,'Giants'	,'0');
INSERT INTO score (team,day,opponent,runs) VALUES('Bay Stars',	'Monday',	'Tigers',	'7');
INSERT INTO score (team,day,opponent,runs) VALUES('Giants',	'Monday'	,'Swallows'	,'5');

SELECT team, day
   FROM score S1
   WHERE runs <= ALL
       (SELECT runs FROM score S2
        WHERE S1.Day = S2.Day
       );
   TEAM		     DAY
   -------------------- --------------------
   Carp		     Sunday
   Bay Stars	     Sunday
   Swallows	     Monday
   
   
   SELECT team, day
       FROM score S1
       WHERE NOT EXISTS
           (SELECT * FROM score S2
            WHERE S1.Runs = S2.Runs AND
                (S1.Team <> S2.Team 
                 OR S1.Day <> S2.Day)
           );
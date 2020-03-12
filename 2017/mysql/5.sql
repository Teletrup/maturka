--CREATE DATABASE zadanie5;

USE zadanie5;

--CREATE TABLE druzyny (id int, nazwa varchar(30), miasto varchar(30));
--LOAD DATA LOCAL INFILE '../Dane_PR2/druzyny.txt' INTO TABLE druzyny FIELDS TERMINATED BY '\t' IGNORE 1 ROWS;

--CREATE TABLE sedziowie (nr varchar(6), imie varchar(20), nazwisko varchar(50));
--LOAD DATA LOCAL INFILE '../Dane_PR2/sedziowie.txt' INTO TABLE sedziowie FIELDS TERMINATED BY '\t' IGNORE 1 ROWS;

--CREATE TABLE wyniki (data date, rodzaj char, gdzie char, id_druzyny int, nr_licencji varchar(6), bramki_zd int, bramki_st int);
--LOAD DATA LOCAL INFILE '../Dane_PR2/wyniki.txt' INTO TABLE wyniki FIELDS TERMINATED BY '\t' IGNORE 1 ROWS;

--SELECT * FROM druzyny;
--SELECT * FROM sedziowie;
--SELECT * FROM wyniki;

--5.1

SELECT rodzaj, count(*) FROM wyniki
JOIN druzyny ON druzyny.id = wyniki.id_druzyny
WHERE miasto LIKE '%kucykowo%'
GROUP BY rodzaj;

SELECT y, max(n) FROM ( /*Zapomniałeś o wypisaniu roku*/
	SELECT year(data) AS y, count(*) AS n FROM wyniki
	JOIN druzyny ON druzyny.id = wyniki.id_druzyny
	WHERE miasto LIKE '%kucykowo%'
	GROUP BY y
	ORDER BY n DESC /*Śmierdzący hack*/
) A;

--5.2
SELECT nazwa FROM (
	SELECT nazwa, sum(bramki_zd) AS zd, sum(bramki_st) AS st FROM druzyny
	JOIN wyniki ON id = id_druzyny
	GROUP BY nazwa /*Zapytania zagnieżdżonego nie można kończyć średnikiem*/
) A 
WHERE zd = st;

--5.3

SELECT count(*) AS wygrane FROM wyniki WHERE gdzie = 'W' AND bramki_zd > bramki_st;
SELECT count(*) AS przegrane FROM wyniki WHERE gdzie = 'W' AND bramki_zd < bramki_st;
SELECT count(*) AS zremisowane FROM wyniki WHERE gdzie = 'W' AND bramki_zd = bramki_st;

--5.4

SELECT (SELECT COUNT(*) FROM sedziowie) - COUNT(DISTINCT nr) AS nie_sedziujacy FROM sedziowie 
JOIN wyniki ON nr = nr_licencji
WHERE rodzaj = 'P';	/*Zapomniałeś, że mają być mecze pucharowe*/



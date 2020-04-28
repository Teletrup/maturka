--create database probny2020;
use probny2020;

--drop table klienci;
--drop table wizyty;
--drop table wizytyzabiegi;
--drop table zabiegi;

--create table klienci (id varchar(6), imie varchar(30), nazwisko varchar(40));
--create table zabiegi (id varchar(9), dzial text, zabieg text, cena int);
--create table wizyty (id int, data date, nr_wizyty int, id_klienta varchar(6));
--create table wizytyzabiegi (id int, id_zabiegu varchar(9));

--load data local infile '../dane/klienci.txt' into table klienci lines terminated by '\r\n' ignore 1 lines;
--load data local infile '../dane/zabiegi.txt' into table zabiegi lines terminated by '\r\n' ignore 1 lines;
--load data local infile '../dane/wizytydane.txt' into table wizyty lines terminated by '\r\n' ignore 1 lines;
--load data local infile '../dane/wizytyzabiegi.txt' into table wizytyzabiegi lines terminated by '\r\n' ignore 1 lines;

--select * from klienci;
--select * from zabiegi;
--select * from wizyty;
--select * from wizytyzabiegi;

select sum(cena) from klienci
join wizyty on klienci.id = id_klienta
join wizytyzabiegi on wizytyzabiegi.id = wizyty.id
join zabiegi on zabiegi.id = id_zabiegu
where imie = 'Alicja' and nazwisko = 'Kowalska';

select imie, nazwisko, count(*) from klienci		/*how does grouping work anyway?*/
join wizyty on klienci.id = id_klienta
group by id_klienta 
order by count(*) desc
limit 1;

select count(*) from wizyty				/*brak liczby dat*/
join wizytyzabiegi on wizyty.id = wizytyzabiegi.id
join zabiegi on id_zabiegu = zabiegi.id
where zabieg like '%Magia Hawajow%';
select data from wizyty
join wizytyzabiegi on wizyty.id = wizytyzabiegi.id
join zabiegi on id_zabiegu = zabiegi.id
where zabieg like '%Magia Hawajow%'
order by data desc; /*nierosnacy a nie rosnacy*/

select count(klienci.id), sum(cena)*0.8 from klienci /*count and repetition*/
join wizyty on klienci.id = id_klienta
join wizytyzabiegi on wizytyzabiegi.id = wizyty.id
join zabiegi on zabiegi.id = id_zabiegu
where klienci.id like 'X%' and dzial like '%makijaz%' and data >= '2017-12-06' and data <= '2018-01-15'; 


select zabieg from zabiegi where dzial like '%fryzjer meski%' and id not in (
	select zabiegi.id from klienci
	join wizyty on klienci.id = id_klienta
	join wizytyzabiegi on wizytyzabiegi.id = wizyty.id
	join zabiegi on zabiegi.id = id_zabiegu
	where dzial like '%fryzjer meski%'
);

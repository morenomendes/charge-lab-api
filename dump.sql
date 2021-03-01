SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

 
DROP TABLE IF EXISTS tb_session CASCADE;
DROP TABLE IF EXISTS tb_station CASCADE;
DROP TABLE IF EXISTS tb_user CASCADE;
DROP TABLE IF EXISTS tb_user_station CASCADE;
DROP SEQUENCE IF EXISTS sq_session;
DROP SEQUENCE IF EXISTS sq_station;
DROP SEQUENCE IF EXISTS sq_user;
DROP SEQUENCE IF EXISTS sq_user_station;
DROP SEQUENCE IF EXISTS fk_station;
DROP SEQUENCE IF EXISTS fk_user;

    create table tb_session (
       id int4 not null,
        charging_time int4,
        cost int4,
        location varchar(255),
        name varchar(255),
        power_consumption int4,
        primary key (id)
    );
    
    create table tb_station (
       id int4 not null,
        avaliability varchar(255),
        details varchar(255),
        location varchar(255),
        name varchar(255),
        primary key (id)
    );
    
    create table tb_user (
       id int4 not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone_number varchar(255) not null,
        primary key (id)
    );
    
    create table tb_user_station (
       id int4 not null,
        fk_station int4,
        fk_user int4,
        primary key (id)
    );
    
create sequence sq_session start 1 increment 1;
create sequence sq_station start 1 increment 1;
create sequence sq_user start 1 increment 1;
create sequence sq_user_station start 1 increment 1;
	
alter table tb_user_station 
   add constraint FKb4u79rc88dbofyy42egs69ch1 
   foreign key (fk_station) 
   references tb_station;

alter table tb_user_station 
   add constraint FKninyjg47xnyosl4nisedp7k1k 
   foreign key (fk_user) 
   references tb_user;
	      

/* tb_user*/
INSERT INTO public.tb_user (
 id ,first_name, last_name, phone_number, email) VALUES 
( nextval ('sq_user'), 'Alan', 'Moreno Mendes', '15557771515', 'alan@teste.com')
 returning id;
 
 /* tb_station */
 
 INSERT INTO public.tb_station (
 id, name, location, details, avaliability) VALUES 
 (nextval ('sq_station'), 'Station -  1', 'Location - 1', 'Details - 1', 'ONLINE'),
 (nextval ('sq_station'), 'Station -  2', 'Location - 2', 'Details - 2', 'OFFLINE'),
 (nextval ('sq_station'), 'Station -  3', 'Location - 3', 'Details - 3', 'ONLINE'),
 (nextval ('sq_station'), 'Station -  4', 'Location - 4', 'Details - 4', 'IN-USE'),
 (nextval ('sq_station'), 'Station -  5', 'Location - 5', 'Details - 5', 'ONLINE')
 returning id;
 
  /* sessions */
 
 INSERT INTO public.tb_session (
 id, location, name, power_consumption, cost, charging_time) VALUES 
( nextval ('sq_session'),'Location - 1', 'Name - 1', '1', '1', '1'),
( nextval ('sq_session'),'Location - 2', 'Name - 2', '2', '2', '2'),
( nextval ('sq_session'),'Location - 3', 'Name - 3', '3', '3', '3'),
( nextval ('sq_session'),'Location - 5', 'Name - 4', '4', '4', '4'),
( nextval ('sq_session'),'Location - 5', 'Name - 5', '5', '5', '5')
 returning id;
 
  /* tb_user_station */

 INSERT INTO public.tb_user_station (
id, fk_user, fk_station) VALUES
(nextval ('sq_user_station'), (select min(id) from tb_user), (select min(id) from tb_session)),
(nextval ('sq_user_station'), (select min(id) from tb_user), (select max(id) from tb_session))
 returning id;


select * from tb_user;




 
 
 
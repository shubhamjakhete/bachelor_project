--drop table Appointment cascade;
--drop table Contact cascade;




create table Appointment (
AppID int PRIMARY KEY,
vName text,
vMobile int,
Purpose text,
ContactID int REFERENCES Contact(contactID),
vLocation text,
vDate date,
vTime date,
Duration date);

select * from Appointment;

/*alter table Appointment
add PRIMARY KEY (AppID);
alter table Appointment
alter column AppID int NOT NULL AUTO_INCREMENT;
commit;



SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";*/


create table Contact (

contactID int PRIMARY KEY,
cName text,
cAddress text,
cMobile int,
cEmail varchar(20) 

);

insert into Contact values (12, 'Ajinkya', 'JM ROAD', 9403789311 , 'aj.yadav97@gmail.com')
select * from Contact;

/*
alter table Contact
	add PRIMARY KEY ( contactID );

alter table Contact
	alter column contactID int NOT NULL AUTO_INCREMENT;
	commit;*/

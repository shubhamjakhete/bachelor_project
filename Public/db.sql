drop table Contact cascade;
drop table Appointment cascade;


create table Appointment(
AppID int PRIMARY KEY,
vName text,
vMobile int,
Purpose text,
ContactID int REFERENCES Contact(contactID),
vLocation text,
vDate date,
vTime varchar(20),
Duration varchar(20));


create table Contact(

contactID int PRIMARY KEY,
cName text,
cAddress text,
cMobile numeric(10,0),
cEmail varchar(80) );

insert into Contact values (12, 'Ajinkya', 'JM ROAD', 9403789311 , 'aj.yadav97@gmail.com');
insert into Contact values (13, 'Shubham', 'PIMPRI', 7507185862 , 'shubhamjakhete97@gmail.com');
insert into Contact values (14, 'ShubhamB', 'JM ROAD', 8007077778 , 'shubhambharati@gmail.com');
insert into Contact values (15, 'Aniket', 'WAKDEWADI', 9876549875 , 'aniket.walse@gmail.com');

select * from Contact;


insert into Appointment values (1, 'PERSON1', 9403789311 ,'APPOINTMENT' , 12 , 'FCROAD' , '12-12-2017' , '111746' , '222013');

select * from Appointment;



drop table Login cascade;
drop table Appointment cascade;
drop table Contact cascade;



create table Contact(

contactID int PRIMARY KEY,
cName text,
cAddress text,
cMobile numeric(10,0),
cEmail varchar(80));

create table Appointment(
AppID int PRIMARY KEY,
vName text,
vMobile numeric(10,0),
Purpose text,
contactID int REFERENCES Contact(contactID),
vLocation text,
vDate date,
vTime varchar(20),
Duration varchar(20));


insert into Contact values (12, 'Ajinkya', 'JM ROAD', 9403789311 , 'aj.yadav97@gmail.com');
insert into Contact values (13, 'Shubham', 'PIMPRI', 7507185862 , 'shubhamjakhete97@gmail.com');
insert into Contact values (14, 'ShubhamB', 'JM ROAD', 8007077778 , 'shubhambharati@gmail.com');
insert into Contact values (15, 'Aniket', 'WAKDEWADI', 9876549875 , 'aniket.walse@gmail.com');

select * from Contact;


insert into Appointment values (1,'Dr.Batra', 9403789311 ,'Consultancy' , 12 , 'FCROAD' , '02/12/2017' , '11:45' , '22');
insert into Appointment values (2,'Dr.Deshmukh', 8007077778 ,'Meeting' , 13 , 'JMROAD' , '03/05/2017' , '11:50' , '21');
insert into Appointment values (3,'Dr.Khatri', 7507185862 ,'Check Up' , 14 , 'PIMPRI' , '04/03/2017' , '11:55' , '20');
insert into Appointment values (4,'Prof.Jakhete', 9874563210 ,'APPOINTMENT' , 15 , 'DECCAN' , '05/09/2017' , '11:55' , '19');
insert into Appointment values (5,'Adv.Jagtap', 9402568974 ,'Legal Issues' , 16 , 'KATRAJ' , '06/11/2017' , '11:40' , '23');


select * from Appointment;

create table Login(
userID int PRIMARY KEY,
pass varchar(20));



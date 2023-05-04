CREATE DATABASE flight;
use flight;

create table Userlogin(
 id int primary key,
 username varchar(45) not null,
 password varchar(45) not null,
 email varchar(45) not null,
 pnumber bigint not null,
 dob date not null,
 gender varchar(45) not null,
 role varchar(45) not null
);

alter table Userlogin
modify id bigint ;

ALTER TABLE Userlogin
RENAME TO userdetails;

create table Flight(
 id bigint primary key,
 flightNumber varchar(45) not null,
 flightName varchar(45) not null,
 model varchar(45) not null,
 type varchar(45) not null,
 economySeats int not null,
 businessSeats int not null,
 firstClassSeats int not null
);
alter table Flight
modify id bigint ;

create table Schedule(
 id int primary key,
 flight_id bigint not null ,
 sdate date not null,
 stime datetime not null,
 source varchar(45) not null,
 destination varchar(45) not null,
 duration int not null,
 atime datetime not null,
foreign key (flight_id) references Flight(id)
);

alter table Schedule
modify stime time;

alter table Schedule
modify atime time;

create table Booking(
 id int primary key,
 schedule_id bigint not null,
 classtype varchar(45) not null,
 passengers int not null,
 user_id bigint not null,
 foreign key (schedule_id) references Schedule(id),
 foreign key (user_id) references Userlogin(id)
);

create table PassengerDetails(
 id int primary key,
 booking_id bigint not null,
 salutation varchar(45) not null,
 firstName varchar(45) not null,
 lastName varchar(45) not null,
 age int not null,
 gender varchar(45) not null
);

select * from Userlogin;
select * from userdetails;
select * from Flight;
select * from Schedule;
select * from Booking;
select * from PassengerDetails;

desc Userlogin;
desc Flight;
desc Schedule;
desc Booking;
desc PassengerDetails;




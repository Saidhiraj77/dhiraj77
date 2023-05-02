create database movies5;
use movies5;
create table myuser(
 userId int primary key auto_increment,
 userName varchar(45) Not null,
 password varchar(45)Not null,
 role varchar(45)Not null,
 email varchar(45)Not null,
 phone varchar(45)Not null,
 gender varchar(45)Not null
);
select * from myuser;
desc myuser;

create table theatre(
  theatreId int primary key auto_increment,
  theatreName varchar(45) not null
);

select * from theatre;
desc theatre;

create table movie (
movieId int primary key auto_increment,
movieName varchar(45) not null,
noOfTickets int not null,
theatreId int not null,
image LONGBLOB ,
foreign key (theatreId) references theatre(theatreId)
);

select * from movie;
desc movie;

create table booking(
id int primary key auto_increment,
bookingDate date not null,
theatre_id int not null,
movie_id int not null,
customer_id int not null,
tickets int not null,
seatType varchar(45) not null,
 foreign key (theatre_id) references theatre(theatreId),
 foreign key (movie_id) references movie(movieId),
 foreign key (customer_id) references myuser(userId)
);

select * from booking;
desc booking;
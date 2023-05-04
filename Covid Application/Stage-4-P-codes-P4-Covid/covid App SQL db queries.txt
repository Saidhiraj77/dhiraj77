create database covid;
use covid;

create table PACUSER(
 id bigint primary key,
 firstName varchar(45) not null,
 lastName varchar(45) not null,
 userName varchar(45) not null,
 email varchar(45) not null,
 gender varchar(45) not null,
 age bigint not null,
 password varchar(45) not null
);
Alter table pacuser
modify id bigint auto_increment ;

create table VCENTERS(
 id bigint primary key,
 name varchar(45) not null,
 pinCode bigint not null
);
Alter table VCENTERS
modify id bigint auto_increment ;

create table SLOTS(
	 id bigint primary key,
	 slotDate date not null,
	  slotTime varchar(45) not null,
	  userName  varchar(45) not null,
	  centerName  varchar(45) not null,
	 vType  varchar(45) not null,
	 aadharNumber  bigint not null
);
Alter table SLOTS
modify id bigint auto_increment ;

select * from PACUSER;	
select * from VCENTERS;	
select * from SLOTS;	



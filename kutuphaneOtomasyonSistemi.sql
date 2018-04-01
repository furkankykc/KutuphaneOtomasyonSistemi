
drop database if exists kutuphaneotomasyonu ;
create database if not exists kutuphaneotomasyonu; 
use kutuphaneotomasyonu;
  
create table Category(
     id int primary key auto_increment,
     catName varchar(30)
);

create table Address(
	id int primary key auto_increment,
	name varchar(30),
    street varchar(30),
    road varchar(30),
    buildNo varchar(30)
);


create table User(
    id int primary key auto_increment,
    firstName varchar(30),
    lastName varchar(30),
    address_id int,
    userName varchar(30),
    password varchar(30),
    FOREIGN KEY (address_id) REFERENCES Address(id)
);
INSERT INTO User (userName,password) VALUES('root','1234');

create table Publisher(
     id int primary key auto_increment,
     pubName varchar(30),
     address_id int,
	   FOREIGN KEY (address_id) REFERENCES Address(id)
     );
   


INSERT INTO Publisher (pubName,address_id) VALUES ('furkan',6);

create table Author(
	  id int not null primary key auto_increment,
    firstName varchar(30),
    lastName varchar(30),
    address_id int,
    FOREIGN KEY (address_id) REFERENCES Address(id)
);

create table Book(

	id int not null primary key auto_increment,
    bookName varchar(30),
    bookPage int ,
    author_id int,
    category_id int,
    publisher_id int,
    printingDate datetime,
    FOREIGN KEY (author_id) REFERENCES Author(id),
    FOREIGN KEY (category_id) REFERENCES Category(id),
    FOREIGN KEY (publisher_id) REFERENCES Publisher(id)
    
);
create table Deposite(
	book_id int ,
    user_id int,
	depositeDate datetime,
    deliveryDate datetime,
    FOREIGN KEY (book_id) REFERENCES Book(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

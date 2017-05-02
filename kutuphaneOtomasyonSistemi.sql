
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
    CONSTRAINT fk_user_address_id FOREIGN KEY (address_id) REFERENCES Address(id)
);


create table Publisher(
     id int primary key auto_increment,
     pubName varchar(30),
     address_id int,
	 CONSTRAINT fk_publisher_address_id FOREIGN KEY (address_id) REFERENCES Address(id)
     );
   




create table Author(
	id int not null primary key auto_increment,
    firstName varchar(30),
    lastName varchar(30),
    address_id int,
    CONSTRAINT fk_author_address_id FOREIGN KEY (address_id) REFERENCES Address(id)
);

create table Book(

	id int not null primary key auto_increment,
    bookName varchar(30),
    bookPage int ,
    author_id int,
    category_id int,
    publisher_id int,
    printingDate datetime,
    CONSTRAINT fk_book_author_id FOREIGN KEY (author_id) REFERENCES Author(id),
    CONSTRAINT fk_book_category_id FOREIGN KEY (category_id) REFERENCES Category(id),
    CONSTRAINT fk_book_publisher_id FOREIGN KEY (publisher_id) REFERENCES Publisher(id)
    
);
create table Deposite(
	book_id int ,
    user_id int,
	depositeDate datetime,
    deliveryDate datetime,
    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES Book(id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES User(id)
);

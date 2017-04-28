
drop database if exists kutuphaneotomasyonu ;
create database if not exists kutuphaneotomasyonu; 
use kutuphaneotomasyonu;
  
create table Category(
     idCategory int primary key,
     catName varchar(30)
);

create table Adress(
	idAdress int primary key,
    street varchar(30),
    road varchar(30),
    buildNo varchar(30)
);




create table User(
    idUser int primary key,
    firtName varchar(30),
    lastName varchar(30),
    adress_id int,
    userName varchar(30),
    password varchar(30),
    CONSTRAINT fk_user_adress_id FOREIGN KEY (adress_id) REFERENCES Adress(idAdress)
);


create table Publisher(
     idPublisher int primary key,
     pubName varchar(30),
     adress_id int,
	 CONSTRAINT fk_publisher_adress_id FOREIGN KEY (adress_id) REFERENCES Adress(idAdress)
     );
   




create table Author(
	idAuthor int not null primary key,
    firstName varchar(30),
    lastName varchar(30),
    adress varchar(50),
    adress_id int,
    CONSTRAINT fk_author_adress_id FOREIGN KEY (adress_id) REFERENCES Adress(idAdress)
);

create table Book(

	idBook int not null primary key,
    bookName varchar(30),
    bookPage int ,
    author_id int,
    category_id int,
    publisher_id int,
    printingDate datetime,
    CONSTRAINT fk_book_author_id FOREIGN KEY (author_id) REFERENCES Author(idAuthor),
    CONSTRAINT fk_book_category_id FOREIGN KEY (category_id) REFERENCES Category(idCategory),
    CONSTRAINT fk_book_publisher_id FOREIGN KEY (publisher_id) REFERENCES Publisher(idPublisher)
    
);
create table Deposite(
	book_id int,
    user_id int,
	depositeDate datetime,
    deliveryDate datetime,
    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES Book(idBook),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES User(idUser)
);

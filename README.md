# EurisDeveloperTest

Database data (MySQL)

create database eurisproject;
use eurisproject;

create table articles(
	identificationcode int primary key auto_increment,
    name varchar(50),
    price varchar(100));
    
insert into articles(name, price) values
("flour", "0p 0s 9d"),
("bread", "0p 1s 5d"),
("wine", "1p 0s 0d"),
("train", "1p 4s 0d"),
("radio", "4p 18s 4d"),
("heater", "5p 17s 0d");

select * from articles;

During the creation and development of the project I used an external library, IMappablePro, 
developed during the course to simplify and speed up the writing of the code by transforming an object into a Map and vice versa, available in the util package.
As scaffholding data I used a database, while to perform REST operations I used Postman.
I've created 2 different interface to perform the requirement task, first of all, List, Insert, Update and Delete of an Item(IInventory), 
second one, the calculation of the old pound of England 1970 within Pound, Shilling and Pence
To overcome the problem of / in postman, I opted for two different parameters, Example firstOperand = 18p 16s 1d and secondOperand = 15, 
automatically the program will understand that if I pass the two parameters it will perform a division, otherwise it would do the operation you've putted as a parameter.

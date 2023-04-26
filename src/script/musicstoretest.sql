create database musicstoretest;

use musicstoretest;

/*TABLE CREATION*/
create table if not exists user(
	idUser integer not null,
    username varchar(25),
    password varchar(25),
    name varchar(25),
    surname varchar(25),
    dateRegister date,
    mail varchar(25),
	primary key(idUser)
);

create table if not exists manager(
	idUser integer,
	isTechnician tinyint,
    isAdmin tinyint,
    idSupervisor integer,
    statusManager enum('Pending', 'Approved', 'Rejected'),
    foreign key (idUser) references user (idUser),
    primary key (idUser)
);

create table if not exists member(
	idUser integer not null,
	address varchar(100),
    creditCard varchar(16),
    foreign key (idUser) references user (idUser),
    primary key (idUser)
);

create table if not exists repair(
	idRepair integer not null,
    idUser integer,
    repairCost integer,
    startDate date,
    deadline date,
    statusRepair enum('Pending', 'In progress', 'Cancelled', 'Accepted', 'Denied', 'Finished'),
    descriptionRepair varchar(200),
    foreign key (idUser) references User (idUser),
    primary key (idRepair)
);

create table if not exists product(
	idProduct integer not null,
    brand varchar(20),
    model varchar(20),
    unitPrice integer,
    stock integer,
    isActive tinyint,
    saleActive tinyint,
    salePercentage integer,
    name varchar(20),
    color varchar(20),
    primary key (idProduct)
);

create table if not exists instrument(
	idProduct integer not null,
	classInstrument enum('Wind', 'String', 'Percussion'),
    typeInstrument enum('Acoustic', 'Electronic'),
	foreign key (idProduct) references product (idProduct),
    primary key (idProduct)
);

create table if not exists component(
	idProduct integer not null,
	classComponent enum('Chasis', 'Circuit'),
    typeComponent enum('Architecture', 'Tuning', 'Connection'),
    foreign key (idProduct) references product (idProduct),
    primary key (idProduct)
);

create table if not exists accessory(
	idProduct integer not null,
	classAccessory enum('Acoustic', 'Electric'),
    typeAccessory enum('Audio', 'Connection', 'Item'),
	foreign key (idProduct) references product (idProduct),
	primary key (idProduct)
);

create table if not exists purchase(
	idPurchase integer not null,
    idUser integer,
    idProduct integer,
	datePurchase date,
    purchaseQuantity integer,
    totalPrice integer,
    paymentStatus enum('New', 'Pending', 'Payment Received', 'Payment Accepted', 'Payment Denied', 'Cancelled', 'Closed'),
	paymendMethod enum('Tarjeta', 'Efectivo'),
    foreign key (idUser) references user (idUser),
    foreign key (idProduct) references product (idProduct),
    primary key (idPurchase)
);

create table if not exists management(
	idManagement integer not null,
    idUser integer,
    idProduct integer,
    dateManagement date,
    actionType enum('Modification', 'Creation', 'Deactivation', 'Other'),
	descriptionM varchar(200),
    foreign key (idProduct) references Product (idProduct),
    foreign key (idUser) references User (idUser),
	primary key (idManagement)
);

/*USERS*/
/*
CREATE USER 'ander'@'localhost' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'ander'@'localhost' WITH GRANT OPTION;
CREATE USER 'ander'@'192.168.20.255' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'ander'@'192.168.20.255' WITH GRANT OPTION;
FLUSH PRIVILEGES;
select user from mysql.user;
*/


insert into user values(
'0', 'Admin', 'abcd*1234',' ',' ','2023-04-26',' '
);
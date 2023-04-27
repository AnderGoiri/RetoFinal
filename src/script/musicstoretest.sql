create database musicstoretest;

use musicstoretest;

/*TABLE CREATION*/
create table if not exists user(
	idUser integer not null unique auto_increment,
    username varchar(25) unique,
    password varchar(25),
    name varchar(25),
    surname varchar(25),
    dateRegister date,
    mail varchar(25),
	primary key(idUser)
);

create table if not exists manager(
	idUser integer not null unique auto_increment,
	isTechnician tinyint,
    isAdmin tinyint,
    idSupervisor integer,
    statusManager enum('Pending', 'Approved', 'Rejected'),
    foreign key (idUser) references user (idUser),
    primary key (idUser)
);

create table if not exists member(
	idUser integer not null unique auto_increment,
	address varchar(100),
    creditCard varchar(16),
    foreign key (idUser) references user (idUser),
    primary key (idUser)
);

create table if not exists repair(
	idRepair integer not null unique auto_increment,
    idUser integer not null,
    repairCost integer,
    startDate date,
    deadline date,
    statusRepair enum('Pending', 'In progress', 'Cancelled', 'Accepted', 'Denied', 'Finished'),
    descriptionRepair varchar(200),
    foreign key (idUser) references User (idUser),
    primary key (idRepair)
);

create table if not exists product(
	idProduct integer not null unique auto_increment,
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
	idProduct integer not null unique auto_increment,
	classInstrument enum('Wind', 'String', 'Percussion'),
    typeInstrument enum('Acoustic', 'Electronic'),
	foreign key (idProduct) references product (idProduct),
    primary key (idProduct)
);

create table if not exists component(
	idProduct integer not null unique auto_increment,
	classComponent enum('Chasis', 'Circuit'),
    typeComponent enum('Architecture', 'Tuning', 'Connection'),
    foreign key (idProduct) references product (idProduct),
    primary key (idProduct)
);

create table if not exists accessory(
	idProduct integer not null unique auto_increment,
	classAccessory enum('Acoustic', 'Electric'),
    typeAccessory enum('Audio', 'Connection', 'Item'),
	foreign key (idProduct) references product (idProduct),
	primary key (idProduct)
);

create table if not exists purchase(
	idPurchase integer not null unique auto_increment,
    idUser integer not null,
    idProduct integer not null,
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
	idManagement integer not null unique auto_increment,
    idUser integer not null,
    idProduct integer not null,
    dateManagement date,
    actionType enum('Modification', 'Creation', 'Deactivation', 'Other'),
	descriptionM varchar(200),
    foreign key (idProduct) references Product (idProduct),
    foreign key (idUser) references User (idUser),
	primary key (idManagement)
);

CALL insert_new_member(' ', ' ', ' ', ' ', '2023-04-16', ' ', ' ', ' ');
/*USERS*/

/*
CREATE USER 'ander'@'192.168.20.255' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'ander'@'192.168.20.255' WITH GRANT OPTION;
FLUSH PRIVILEGES;
select user from mysql.user;
*/

insert into user values(
'Admin', 'abcd*1234',' ',' ','2023-04-26',' '
);

select * from user;
select * from member;
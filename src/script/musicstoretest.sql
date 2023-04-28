create database musicstoretest;

use musicstoretest;

/*TABLE CREATION*/
create table if not exists user(
	idUser integer not null unique auto_increment,
    username varchar(25) unique,
    name varchar(25),
    surname varchar(25),
    password varchar(25),
    mail varchar(25),
    dateRegister date,
	primary key(idUser)
);

create table if not exists manager(
	idUser integer not null unique auto_increment,
	isTechnician tinyint,
    isAdmin tinyint,
    idSupervisor integer,
    statusManager enum('Pending', 'Approved', 'Rejected'),
    foreign key (idUser) references user (idUser) on delete cascade,
    primary key (idUser)
);

create table if not exists member(
	idUser integer not null unique auto_increment,
	address varchar(100),
    creditCard varchar(16),
    foreign key (idUser) references user (idUser) on delete cascade,
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
    foreign key (idUser) references User (idUser) on delete cascade,
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
	foreign key (idProduct) references product (idProduct) on delete cascade,
    primary key (idProduct)
);

create table if not exists component(
	idProduct integer not null unique auto_increment,
	classComponent enum('Chasis', 'Circuit'),
    typeComponent enum('Architecture', 'Tuning', 'Connection'),
    foreign key (idProduct) references product (idProduct) on delete cascade,
    primary key (idProduct)
);

create table if not exists accessory(
	idProduct integer not null unique auto_increment,
	classAccessory enum('Acoustic', 'Electric'),
    typeAccessory enum('Audio', 'Connection', 'Item'),
	foreign key (idProduct) references product (idProduct) on delete cascade,
	primary key (idProduct)
);

create table if not exists purchase(
	idPurchase integer not null unique auto_increment,
    idUser integer,
    idProduct integer,
	datePurchase date,
    purchaseQuantity integer,
    totalPrice integer,
    paymentStatus enum('New', 'Pending', 'Payment Received', 'Payment Accepted', 'Payment Denied', 'Cancelled', 'Closed'),
	paymendMethod enum('Tarjeta', 'Efectivo'),
    foreign key (idUser) references user (idUser) on delete cascade,
    foreign key (idProduct) references product (idProduct) on delete cascade,
    primary key (idPurchase)
);

create table if not exists management(
	idManagement integer not null unique auto_increment,
    idUser integer not null,
    idProduct integer not null,
    dateManagement date,
    actionType enum('Modification', 'Creation', 'Deactivation', 'Other'),
	descriptionM varchar(200),
    foreign key (idUser) references User (idUser) on delete cascade,
	primary key (idManagement)
);

CALL insert_new_member('Prueba4', 'Test', 'User', 'test123', 'testuser@example.com', '1990-01-01', '123 Main St', '1234567890123456');
/*USERS*/

/*
CREATE USER 'root'@'192.168.20.255' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'root'@'192.168.20.255' WITH GRANT OPTION;
CREATE USER 'ander'@'192.168.20.255' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'ander'@'192.168.20.255' WITH GRANT OPTION;
FLUSH PRIVILEGES;
select user from mysql.user;
*/
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_member`(
    IN p_username VARCHAR(25),
    IN p_name VARCHAR(25),
    IN p_surname VARCHAR(25),
    IN p_password VARCHAR(25),
    IN p_mail VARCHAR(25),
    IN p_dateRegister DATE,
    IN p_address VARCHAR(100),
    IN p_creditCard VARCHAR(16)
)
BEGIN
    -- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES (p_username, p_name, p_surname, p_password, p_mail, p_dateRegister);
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO member (idUser, address, creditCard)
    VALUES (@new_user_id, p_address, p_creditCard);
END
//
insert into user values(
'Admin', 'abcd*1234',' ',' ','2023-04-26',' '
);

select * from user u join member m on u.idUser = m.idUser;
select * from user;


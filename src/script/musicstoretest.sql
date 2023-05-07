create database musicstoretest;

use musicstoretest;

/*TABLE CREATION*/
create table if not exists user(
	idUser integer not null unique auto_increment,
    username varchar(25) unique,
    name varchar(25),
    surname varchar(25),
    password varchar(25),
    mail varchar(50) unique,
    dateRegister date,
	primary key(idUser)
);

create table if not exists manager(
	idUser integer not null unique auto_increment,
    idSupervisor integer,  
    isSupervisor tinyint not null,
	isTechnician tinyint not null,
    isAdmin tinyint not null,
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
    description varchar(200),
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
	datePurchase date,
    purchaseQuantity integer,
    totalPrice integer,
    purchaseStatus enum('In process', 'Finished'),
    foreign key (idUser) references user (idUser) on delete cascade,
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

/*USERS*/
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'abcd*1234';
GRANT ALL PRIVILEGES ON musicstoretest.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE insert_superadmin()
BEGIN
	-- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("Superadmin", null , null , "abcd*1234", null, CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE create_usersdb ()
BEGIN
	CREATE USER 'ander'@'localhost' IDENTIFIED BY 'abcd*1234';
	GRANT ALL PRIVILEGES ON musicstoretest.* TO 'ander'@'localhost' WITH GRANT OPTION;
	FLUSH PRIVILEGES;
	CREATE USER 'jago'@'localhost' IDENTIFIED BY 'abcd*1234';
	GRANT ALL PRIVILEGES ON musicstoretest.* TO 'jago'@'localhost' WITH GRANT OPTION;
	FLUSH PRIVILEGES;
	CREATE USER 'olaia'@'localhost' IDENTIFIED BY 'abcd*1234';
	GRANT ALL PRIVILEGES ON musicstoretest.* TO 'olaia'@'localhost' WITH GRANT OPTION;
	FLUSH PRIVILEGES;
	CREATE USER 'fran'@'localhost' IDENTIFIED BY 'abcd*1234';
	GRANT ALL PRIVILEGES ON musicstoretest.* TO 'fran'@'localhost' WITH GRANT OPTION;
	FLUSH PRIVILEGES;
END
//
call insert_superadmin;
call create_usersdb;

/*INSERTS*/
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_manager`(
    IN p_username VARCHAR(25),
    IN p_name VARCHAR(25),
    IN p_surname VARCHAR(25),
    IN p_password VARCHAR(25),
    IN p_mail VARCHAR(50),
    IN p_dateRegister DATE,
    IN p_idSupervisor INTEGER,
    IN is_Supervisor tinyint,
    IN is_Technician tinyint,
    IN is_Admin tinyint,
    IN p_statusManager enum('Pending', 'Approved', 'Rejected')
)
BEGIN
    -- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES (p_username, p_name, p_surname, p_password, p_mail, p_dateRegister);
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new manager into the manager table
    INSERT INTO manager (idUser, idSupervisor, isTechnician, isSupervisor, isAdmin, statusManager)
    VALUES (@new_user_id, p_idSupervisor, is_Technician, is_Supervisor, is_Admin, p_statusManager);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_member`(
    IN p_username VARCHAR(25),
    IN p_name VARCHAR(25),
    IN p_surname VARCHAR(25),
    IN p_password VARCHAR(25),
    IN p_mail VARCHAR(50),
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
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_instrument`(
    IN p_brand varchar(20),
    IN p_model varchar(20),
	IN p_description varchar(200),
    IN p_unitPrice integer,
    IN p_stock integer,
    IN is_Active tinyint,
    IN p_saleActive tinyint,
    IN p_salePercentage integer,
    IN p_name varchar(20),
    IN p_color varchar(20),
    IN p_classInstrument enum('Wind', 'String', 'Percussion'),
    IN p_typeInstrument enum('Acoustic', 'Electronic')
)
BEGIN
	-- Insert the new product into the product table
    INSERT INTO product (brand, model, description, unitPrice, stock, isActive, saleActive, salePercentage, name, color)
    VALUES (p_brand, p_model, p_description, p_unitPrice, p_stock, is_Active, p_saleActive, p_salePercentage, p_name, p_color);
    -- Get the ID of the new product
    SET @new_product_id = LAST_INSERT_ID();
    -- Insert the new instrument into the instrument table
    INSERT INTO instrument (idProduct, classInstrument, typeInstrument)
    VALUES (@new_product_id, p_classInstrument, p_typeInstrument);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_component`(
    IN p_brand varchar(20),
    IN p_model varchar(20),
	IN p_description varchar(200),
    IN p_unitPrice integer,
    IN p_stock integer,
    IN is_Active tinyint,
    IN p_saleActive tinyint,
    IN p_salePercentage integer,
    IN p_name varchar(20),
    IN p_color varchar(20),
    IN p_classComponent enum('Chasis', 'Circuit'),
    IN p_typeComponent enum('Architecture', 'Tuning', 'Connection')
)
BEGIN
	-- Insert the new product into the product table
    INSERT INTO product (brand, model, description, unitPrice, stock, isActive, saleActive, salePercentage, name, color)
    VALUES (p_brand, p_model, p_description, p_unitPrice, p_stock, is_Active, p_saleActive, p_salePercentage, p_name, p_color);
    -- Get the ID of the new product
    SET @new_product_id = LAST_INSERT_ID();
    -- Insert the new component into the component table
    INSERT INTO component (idProduct, classComponent, typeComponent)
    VALUES (@new_product_id, p_classComponent, p_typeComponent);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_accessory`(
    IN p_brand varchar(20),
    IN p_model varchar(20),
	IN p_description varchar(200),
    IN p_unitPrice integer,
    IN p_stock integer,
    IN is_Active tinyint,
    IN p_saleActive tinyint,
    IN p_salePercentage integer,
    IN p_name varchar(20),
    IN p_color varchar(20),
    IN p_classAccessory enum('Electric', 'Non-electric'),
    IN p_typeAccessory enum('Audio', 'Connection', 'Item')
)
BEGIN
	-- Insert the new product into the product table
    INSERT INTO product (brand, model, description, unitPrice, stock, isActive, saleActive, salePercentage, name, color)
    VALUES (p_brand, p_model, p_description, p_unitPrice, p_stock, is_Active, p_saleActive, p_salePercentage, p_name, p_color);
    -- Get the ID of the new product
    SET @new_product_id = LAST_INSERT_ID();
    -- Insert the new accessory into the accessory table
    INSERT INTO accessory (idProduct, classAccessory, typeAccessory)
    VALUES (@new_product_id, p_classAccessory, p_typeAccessory);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_purchase`(
    IN p_idUser integer,
	IN p_purchaseQuantity integer, 
    IN p_totalPrice integer,
	IN p_purchaseStatus enum('In process', 'Finished')
)
BEGIN
    -- Get the ID of the new product
	SET @new_purchase_id = LAST_INSERT_ID();
    -- Insert the new purchase into the purchase table
    INSERT INTO purchase (idPurchase, idUser, datePurchase, totalPrice, purchaseStatus)
    VALUES (@new_purchase_id, p_idUser, CAST(GETDATE() AS Date), p_totalPrice, p_purchaseStatus);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_repair`(
    IN p_idUser integer,
    IN p_repairCost integer,
    IN p_deadline date,
    IN p_statusRepair enum('Pending', 'In progress', 'Cancelled', 'Accepted', 'Denied', 'Finished'),
    IN p_descriptionRepair varchar(200)
)
BEGIN
    -- Get the ID of the new product
	SET @new_repair_id = LAST_INSERT_ID();
    -- Insert the new repair into the repair table
    INSERT INTO repair (idRepair, idUser, repairCost, startDate, deadline, statusRepair, descriptionRepair)
    VALUES (@new_repair_id, p_idUser, p_repairCost, CAST(GETDATE() AS Date) , p_deadline, p_statusRepair, p_descriptionRepair);
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_management`(
    IN p_idUser integer,
    IN p_idProduct integer,
    IN p_dateManagement date,
    IN p_actionType enum('Modification', 'Creation', 'Deactivation', 'Other'),
	IN p_descriptionM varchar(200)
)
BEGIN
    -- Get the ID of the new product
	SET @new_management_id = LAST_INSERT_ID();
    -- Insert the new management into the management table
    INSERT INTO management (idManagement, idUser, idProduct, dateManagement, actionType, descriptionM)
    VALUES (@new_management_id, p_idUser, p_idProduct, p_dateManagement, p_actionType, p_descriptionM);
END
//
/*SELECTS*/
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_manager`()
BEGIN
	SELECT * from user u join manager ma on u.idUser = ma.idUser;
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_member`()
BEGIN
	SELECT * from user u join member me on u.idUser = me.idUser;
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_instrument`()
BEGIN
	SELECT * from product p join instrument i on p.idProduct = i.idProduct;
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_component`()
BEGIN
	SELECT * from product p join component c on p.idProduct = c.idProduct; 
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_accessory`()
BEGIN
	SELECT * from product p join accessory a on p.idProduct = a.idProduct;
END
//
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `check_product_exists`(
    IN p_idProduct integer,
    OUT p_exists boolean
)
BEGIN
    DECLARE done boolean;
    DECLARE product_id integer; 
   
   -- Declare cursor
    DECLARE product_cursor CURSOR FOR SELECT idProduct FROM product;

    -- Declare handlers
    -- When the cursor finishes going through the rows, this handler is used to end the loop
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;

    SET p_exists = FALSE;
    OPEN product_cursor;
    product_loop: LOOP
        FETCH product_cursor INTO product_id;
        
        IF product_id = p_idProduct THEN
            SET p_exists = TRUE;
            LEAVE product_loop;
        END IF;  
        
        IF done THEN
            LEAVE product_loop;
        END IF;

    END LOOP;

    CLOSE product_cursor;
END
//

DELIMITER //
CREATE TRIGGER email_formattrigger BEFORE INSERT ON user
FOR EACH ROW
BEGIN
    IF NEW.mail NOT REGEXP '^[A-Za-z0-9.]+@[A-Za-z0-9._]+[.]+[A-Za-z]' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid email format';
    END IF;
END //
CREATE PROCEDURE `create_usersdb` ()
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_manager`()
BEGIN
	SELECT * from user u join manager ma on u.idUser = ma.idUser;
END
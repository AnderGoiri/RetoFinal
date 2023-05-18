CREATE DEFINER=`root`@`localhost` PROCEDURE `select_member`()
BEGIN
	SELECT * from user u join member me on u.idUser = me.idUser;
END
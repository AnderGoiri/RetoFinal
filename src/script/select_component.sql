CREATE DEFINER=`root`@`localhost` PROCEDURE `select_component`()
BEGIN
	SELECT * from product p join component c on p.idProduct = c.idProduct; 
END
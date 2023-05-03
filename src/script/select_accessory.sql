CREATE DEFINER=`root`@`localhost` PROCEDURE `select_accessory`()
BEGIN
	SELECT * from producto p join accessory a on p.idProducto = a.idProducto;
END
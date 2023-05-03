CREATE DEFINER=`root`@`localhost` PROCEDURE `select_instrument`()
BEGIN
	SELECT * from producto p join instrument i on p.idProducto = i.idProducto;
END
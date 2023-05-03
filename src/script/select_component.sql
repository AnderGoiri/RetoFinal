CREATE DEFINER=`root`@`localhost` PROCEDURE `select_component`()
BEGIN
	SELECT * from producto p join component c on p.idProducto = c.idProducto; 
END
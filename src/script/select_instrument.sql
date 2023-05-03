CREATE DEFINER=`root`@`localhost` PROCEDURE `select_instrument`()
BEGIN
	SELECT * from product p join instrument i on p.idProduct = i.idProduct;
END
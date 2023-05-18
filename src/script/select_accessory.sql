CREATE DEFINER=`root`@`localhost` PROCEDURE `select_accessory`()
BEGIN
	SELECT * from product p join accessory a on p.idProduct = a.idProduct;
END
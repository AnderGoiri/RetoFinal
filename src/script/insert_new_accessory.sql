CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_accessory`(
    IN p_brand varchar(20),
    IN p_model varchar(20),
	IN p_description varchar(20),
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
    INSERT INTO accessory (classAccessory, typeAccessory)
    VALUES (@new_product_id, p_classAccessory, p_typeAccessory);
END
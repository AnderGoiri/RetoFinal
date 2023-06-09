CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_component`(
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
    IN p_classComponent enum('Chasis', 'Circuit'),
    IN p_typeComponent enum('Architecture', 'Tuning', 'Connection')
)
BEGIN
	-- Insert the new product into the product table
    INSERT INTO product (brand, model, description, unitPrice, stock, isActive, saleActive, salePercentage, name, color)
    VALUES (p_brand, p_model, p_description, p_unitPrice, p_stock, is_Active, p_saleActive, p_salePercentage, p_name, p_color);
    -- Get the ID of the new product
    SET @new_product_id = LAST_INSERT_ID();
    -- Insert the new component into the component table
    INSERT INTO component (idProduct, classComponent, typeComponent)
    VALUES (@new_product_id, p_classComponent, p_typeComponent);
END
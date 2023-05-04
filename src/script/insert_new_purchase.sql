CREATE PROCEDURE `insert_new_purchase` (
    IN p_idUser integer,
    IN p_datePurchase date,
	IN p_purchaseQuantity integer, 
    IN p_totalPrice integer,
    IN p_paymentStatus enum('New', 'Pending', 'Payment Received', 'Payment Accepted', 'Payment Denied', 'Cancelled', 'Closed'),
	IN p_paymendMethod enum('Tarjeta', 'Efectivo')
)
BEGIN
    -- Get the ID of the new product
	SET @new_purchase_id = LAST_INSERT_ID();
    -- Insert the new product into the product table
    INSERT INTO purchase (idPurchase, idUser, datePurchase, totalPrice, paymentStatus, paymentMethod)
    VALUES (@new_purchase_id, p_idUser, p_datePurchase, p_totalPrice, p_paymentStatus, p_paymentMethod);
END

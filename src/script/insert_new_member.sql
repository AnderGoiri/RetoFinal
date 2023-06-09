CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_new_member`(
    IN p_username VARCHAR(25),
    IN p_name VARCHAR(25),
    IN p_surname VARCHAR(25),
    IN p_password VARCHAR(25),
    IN p_mail VARCHAR(25),
    IN p_dateRegister DATE,
    IN p_address VARCHAR(100),
    IN p_creditCard VARCHAR(16)
)
BEGIN
    -- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES (p_username, p_name, p_surname, p_password, p_mail, p_dateRegister);
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO member (idUser, address, creditCard)
    VALUES (@new_user_id, p_address, p_creditCard);
END
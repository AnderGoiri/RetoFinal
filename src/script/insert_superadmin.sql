CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_superadmin`(

)
BEGIN
	-- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("Superadmin", null , null , "abcd*1234", null, CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');
END
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_devs`()
BEGIN
	-- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("devAnder", "Ander", "Goirigolzarri", "abcd*1234", "ander.goiritur@gmail.com", CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');

	-- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("devOlaia", "Olaia", "Sainz", "abcd*1234", "Olaialor@gmail.com", CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');
    
    -- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("devFran", "Fran", "de Ysasi", "abcd*1234", "fdeysasigonzalez@gmail.com", CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');
    
	-- Insert the new user into the user table
    INSERT INTO user (username, name, surname, password, mail, dateRegister)
    VALUES ("devJago", "Jagoba", "Bartolomé", "abcd*1234", "jagoba1207@gmail.com", CAST(GETDATE() AS Date));
    -- Get the ID of the new user
    SET @new_user_id = LAST_INSERT_ID();
    -- Insert the new member into the member table
    INSERT INTO manager (idUser, idSupervisor, isSupervisor, isTechnician, isAdmin, statusManager)
    VALUES (@new_user_id, null , 1, 1, 1, 'Approved');
END
package logicTier;

import java.sql.SQLException;
import java.time.LocalDate;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import model.Member;

public class Main {

	public static void main(String[] args) {

		String date = "1990-01-01";
		LocalDate localdate = LocalDate.parse(date);
		LoginControllableImplementation loginControl = new LoginControllableImplementation();

		Member me = new Member("testuser", "Test", "User", "test123", "testuser@example.com", localdate, "123 Main St",
				"1234567890123456");
		
		try {
			loginControl.registerUserMember(me);
		} catch (CredentialNotValidException | UserFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

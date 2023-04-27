package logicTier;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import exceptions.CredentialNotValidException;
import exceptions.UserFoundException;
import model.Member;

public class Main {

	public static void main(String[] args) {

		String date = "1990-01-01";
		LocalDate localdate = LocalDate.parse(date);
		LoginControllableImplementation loginControl;
		Connection conn;
		PreparedStatement stmt;
		ResultSet rset;

		Member me = new Member("testuser", "Test", "User", "test123", "testuser@example.com", localdate, "123 Main St",
				"1234567890123456");

		String userName = me.getUserName();
		
		
		try {
			new LoginControllableImplementation().registerUserMember(me);
		} catch (CredentialNotValidException | UserFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

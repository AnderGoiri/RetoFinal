package logicTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Class with the open and close connection methods with the DB.
 * 
 * @author Ander Goirigolzarri Iturburu
 */
public class GateDB {

	private ResourceBundle configFile;
	private String url, user, pass;
	private Connection conn;

	public GateDB() {
		configFile = ResourceBundle.getBundle("logicTier.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	/**
	 * Establishes a connection to the database using the URL, user, and password
	 * set when creating the GateDB object.
	 * 
	 * @return a connection object to the database
	 * @throws SQLException if the connection could not be established
	 * @throws SQLException
	 */
	public Connection openConnection() {
		if (conn != null) {
			return conn;
		}
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Method used to close a connection with the database.
	 * 
	 * @param conn The <code>Connection</code> to close.
	 * @throws SQLException if any error occurs while closing the connection, the
	 *                      statement, or the result set.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	public Connection closeConnection() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
	}
}

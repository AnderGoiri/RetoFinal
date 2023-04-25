package logicTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * @author Ander
 * 
 *         Class with the open and close connection methods with the DB.
 *
 */
public class GateDB {

	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	public GateDB() {
		configFile = ResourceBundle.getBundle("modelo.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	/**
	 * Method used to open a connection with the database
	 * 
	 * @throws SQLException
	 */
	public Connection openConnection() throws SQLException {
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return conn;
	}

	/**
	 * Method used to close a connection with the database. It is important to close
	 * the <code>Statement</code> and <code>ResulSet</code> to avoid memory leaks.
	 * 
	 * @throws SQLException
	 */
	public void closeConnection(PreparedStatement stmt, Connection conn, ResultSet rset) throws SQLException {
		if (stmt != null)
			stmt.close();
		if (rset != null)
			rset.close();
		if (conn != null)
			conn.close();
	}
}

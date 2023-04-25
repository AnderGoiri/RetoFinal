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
	private String url, user, pass;

	public GateDB() {
		configFile = ResourceBundle.getBundle("logicTier.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	/**
	 * @author Ander
	 * 
	 *         Establishes a connection to the database using the URL, user, and
	 *         password set when creating the GateDB object.
	 * 
	 * @return a connection object to the database
	 * @throws SQLException if the connection could not be established
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
	 * @author Ander
	 * 
	 *         Method used to close a connection with the database. It is important
	 *         to close the <code>Statement</code> and <code>ResultSet</code> to
	 *         avoid memory leaks.
	 *         
	 * @param stmt The <code>PreparedStatement</code> to close.
	 * @param conn The <code>Connection</code> to close.
	 * @param rset The <code>ResultSet</code> to close.
	 * @throws SQLException if any error occurs while closing the connection, the
	 *                      statement, or the result set.
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

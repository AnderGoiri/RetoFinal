package logicTier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 
 * Class with the open and close connection methods with the DB.
 * 
 * @author Ander Goirigolzarri Iturburu
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
	 * 
	 * Establishes a connection to the database using the URL, user, and password
	 * set when creating the GateDB object.
	 * 
	 * @return a connection object to the database
	 * @throws SQLException if the connection could not be established
	 * @throws SQLException
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	public Connection openConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * Method used to close a connection with the database.
	 * 
	 * @param conn The <code>Connection</code> to close.
	 * @throws SQLException if any error occurs while closing the connection, the
	 *                      statement, or the result set.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 *
	public Connection closeConnection() throws SQLException {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
	}/

	/**
	 * 
	 * Method used to close a connection with the database. It is important to close
	 * the <code>Statement</code> and <code>ResultSet</code> to avoid memory leaks.
	 * 
	 * @param stmt The <code>PreparedStatement</code> to close
	 * @param conn The <code>Connection</code> to close.
	 * @param rset The <code>ResultSet</code> to close.
	 * @throws SQLException if any error occurs while closing the connection, the
	 *                      statement, or the result set.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	public void closeConnection(PreparedStatement ptmt, Connection conn, ResultSet rset) throws SQLException {
		if (ptmt != null)
			ptmt.close();
		if (rset != null)
			rset.close();
		if (conn != null)
			conn.close();
	}

	public void closeConnection(Statement stmt, Connection conn, ResultSet rset) throws SQLException {
		if (stmt != null)
			stmt.close();
		if (rset != null)
			rset.close();
		if (conn != null)
			conn.close();
	}

	public void closeConnection(CallableStatement ctmt, Connection conn, ResultSet rset) throws SQLException {
		if (ctmt != null)
			ctmt.close();
		if (rset != null)
			rset.close();
		if (conn != null)
			conn.close();
	}
	
	public void closeConnection(ResultSet rset, Statement stmt, Connection conn) throws SQLException {
		if (rset != null)
			rset.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

	public void closeConnection(PreparedStatement stmt, Connection conn) throws SQLException {
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	
	public void closeConnection(CallableStatement ctmt, Connection conn) throws SQLException {
		if (ctmt != null)
			ctmt.close();
		if (conn != null)
			conn.close();
	}

	/**
	 * 
	 * Method used to close a connection with the database. It is important to close
	 * the <code>ResultSet</code> to avoid memory leaks.
	 * 
	 * @param stmt The <code>PreparedStatement</code> to close.
	 * @param conn The <code>Connection</code> to close.
	 * @param rset The <code>ResultSet</code> to close.
	 * @throws SQLException if any error occurs while closing the connection, the
	 *                      statement, or the result set.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	public void closeConnection(Connection conn, ResultSet rset) throws SQLException {
		if (rset != null)
			rset.close();
		if (conn != null)
			conn.close();
	}
}

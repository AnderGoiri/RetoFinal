package logicTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GateDB {
	
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;
	
	public GateDB(){
		configFile = ResourceBundle.getBundle("logicTier.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}
	/**
	 * 
	 * @return Open connection
	 * @throws SQLException
	 * TODO Crear Exception
	 */
	public Connection openConnection() throws SQLException {
		Connection con= null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return con;
	}
	/**
	 * Se cierran los 3 parámetros para evitar pérdidas de memoria
	 * @param stmt
	 * @param con
	 * @param rset
	 * @throws SQLException
	 */
	public void closeConnection(PreparedStatement stmt, Connection con, ResultSet rset) throws SQLException{
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
		if (rset != null) {
			rset.close();
		}
	}
}

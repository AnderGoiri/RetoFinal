package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * @author Ander
 * 
 *         The {@code GateDBTest} class is a test suite for the {@link GateDB}
 *         class. It includes two test methods to check if the connection to the
 *         database is correctly established and closed. It uses JUnit 5
 *         framework and requires a database instance to run the tests.
 */
class GateDBTest {

	GateDB gate = new GateDB();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rset = null;

	/**
	 * @author Ander
	 * 
	 *         Tests the {@link GateDB#openConnection() openConnection} method of
	 *         the {@link GateDB} class to check if a connection to the database is
	 *         correctly established. If the connection is not established, the test
	 *         fails. The test requires a valid database instance to run.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	@Test
	void connectionOpenedWithDB() {
		try {
			conn = gate.openConnection();
			assertFalse(conn.isClosed(), "Connection was not established correctly");
		} catch (SQLException e) {
			fail("Connection could not be established with: " + e.getMessage());
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				fail("Connection could not be closed with: " + e.getMessage());
			}
		}
	}

	/**
	 * @author Ander
	 * 
	 *         Tests the
	 *         {@link GateDB#closeConnection(PreparedStatement, Connection, ResultSet)
	 *         closeConnection} method of the {@link GateDB} class to check if a
	 *         connection to the database is correctly closed. The test executes a
	 *         SELECT statement and checks if it returns any result. If the
	 *         connection is not closed correctly, or the query does not return any
	 *         result, the test fails. The test requires a valid database instance
	 *         to run.
	 *
	 * @throws SQLException if a database access error occurs
	 */
	@Test
	void connectionClosedWithDB() {
		try {
			conn = gate.openConnection();
			stmt = conn.prepareStatement("SELECT * FROM centro");
			rset = stmt.executeQuery();
			assertTrue(rset.next(), "Query has not returned any result.");
		} catch (SQLException e) {
			fail("Query could not be executed: " + e.getMessage());
		} finally {
			try {
				gate.closeConnection(stmt, conn, rset);
				assertTrue(conn.isClosed(), "Connection was not closed correctly");
			} catch (SQLException e) {
				fail("Connection could not be closed with: " + e.getMessage());
			}
		}
	}
}

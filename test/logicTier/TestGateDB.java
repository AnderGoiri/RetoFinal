package logicTier;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The {@code TestGateDB} class is a test suite for the {@link GateDB} class. It
 * includes test methods to check if the connection to the database is correctly
 * established and closed and if
 * 
 * @author Ander Goirigolzarri Iturburu
 */
class TestGateDB {

	private GateDB gate = new GateDB();

	@AfterEach
	void closeConnectionAfterTest() {
		gate.closeConnection();
	}
	
	/**
	 * Test case to verify if the openConnection method successfully establishes a
	 * connection with the database.
	 * 
	 * @throws SQLException if there is an error while connecting to the database.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testOpenConnectionWithDBSuccesful() throws SQLException {
		assertNotNull(gate.openConnection(), "Connection should be successful.");
	}

	/**
	 * Test case to verify if the openConnection method successfully establishes a
	 * connection with the database and can retrieve data from the database.
	 * 
	 * @throws SQLException if there is an error while connecting to the database or
	 *                      executing the SQL query.
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testOpenConnectionWithDBWorks() throws SQLException {
		assertTrue(gate.openConnection().isValid(0), "Connection is not established correctly");
		assertNotNull(gate.openConnection().createStatement().executeQuery("SELECT true;"),
				"Data retrieve from DB fails");
	}

	/**
	 * 
	 * @throws SQLException
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testCloseConnectionWithDBSuccesful() throws SQLException {
		assertTrue(gate.closeConnection(gate.openConnection()).isClosed());
	}

	/**
	 * 
	 * @throws SQLException
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	void testCloseConnectionWithDBWorks() throws SQLException {
		java.sql.SQLNonTransientConnectionException thrown = Assertions
				.assertThrows(java.sql.SQLNonTransientConnectionException.class, () -> {
					assertTrue(gate.closeConnection(gate.openConnection()).isClosed(), "Connection is not closed correctly");
					assertNotNull(gate.closeConnection(gate.openConnection()).createStatement().executeQuery("SELECT true;"),
							"Data retrieve from DB fails");
				});
		Assertions.assertEquals("No operations allowed after connection closed.", thrown.getMessage());
	}
}

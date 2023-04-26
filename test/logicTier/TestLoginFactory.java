package logicTier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * 
 * The Test LoginFactory class is a JUnit test class that tests the
 * functionality of the LoginFactory class.
 * 
 * It tests the getLoginControllable() method of the LoginFactory class, which
 * returns a LoginControllable object.
 * 
 * The test ensures that the object returned is not null and is an instance of
 * the LoginControllableImplementation class.
 * 
 * @author Ander Goirigolzarri Iturburu
 *
 */
public class TestLoginFactory {

	/**
	 * Tests the getLoginControllable() method of the LoginFactory class. It asserts
	 * that the method returns a non-null LoginControllable object, and that the
	 * object is an instance of the LoginControllableImplementation class.
	 * 
	 * @author Ander Goirigolzarri Iturburu
	 */
	@Test
	public void testGetLoginControllable() {
		LoginControllable loginControllable = LoginFactory.getLoginControllable();
		assertNotNull(loginControllable);
		assertEquals(LoginControllableImplementation.class, loginControllable.getClass());
	}
}
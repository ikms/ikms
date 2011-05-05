/**
 * 
 */
package net.sf.ikms.test;

import net.sf.ikms.domain.User;
import net.sf.ikms.service.impl.UserService;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Oxidy
 * 
 */
public class UserTest {

	UserService userService = null;

	@Before
	public void set() {

	}

	@Test
	public void testGetUser() {
		try {
			String userId = "1";
			User user = userService.getUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * 
 */
package net.sf.ikms.test;

import net.sf.ikms.domain.User;
import net.sf.ikms.service.impl.UserServiceImpl;

import org.junit.Test;

/**
 * @author Oxidy
 * 
 */
public class UserTest {

	UserServiceImpl userService = null;
	
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

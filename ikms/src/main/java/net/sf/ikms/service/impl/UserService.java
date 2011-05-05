/**
 * 
 */
package net.sf.ikms.service.impl;

import net.sf.ikms.domain.User;
import net.sf.ikms.service.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Oxidy
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String userId){
		return userMapper.getUser(userId);
	}
}

package net.sf.ikms.service.impl;

import net.sf.ikms.domain.User;
import net.sf.ikms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-5 下午05:27:32
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserService userService;
	
	public User getUser(String userId){
		return userService.getUser(userId);
	}
}

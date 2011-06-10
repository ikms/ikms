/**
 * 
 */
package net.sf.ssi.service.impl;

import net.sf.ssi.domain.User;
import net.sf.ssi.mapper.UserMapper;
import net.sf.ssi.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:25:35
 *
 */
@Service
public class UserService<T extends User> implements IUserService<T> {
	
	@Autowired
	private UserMapper mapper;

	/**
	 * @return the mapper
	 */
	public UserMapper getMapper() {
		return mapper;
	}

	/**
	 * @param mapper the mapper to set
	 */
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getInfoByKey(String key) throws DataAccessException {
		 T entity = null;
	        try {
//	        	User user = new User();
//	        	user.setPassword("1");
//	        	user.setUserId("2");
//	        	user.setUserName("text");
//	        	entity = (T) user;
	            entity = (T) mapper.getInfoByKey(key);
	        } catch (DataAccessException e) {
	            throw e;
	        }
	        return entity;
	}

}

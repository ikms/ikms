/**
 * 
 */
package net.sf.ssi.service.impl;

import net.sf.ssi.domain.User;
import net.sf.ssi.mapper.UserMapper;
import net.sf.ssi.service.UserService;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:25:35
 *
 */
public class UserServiceImpl<T extends User> implements UserService<T> {
	
	private UserMapper mapper;

	@SuppressWarnings("unchecked")
	@Override
	public T getInfo(String key) throws DataAccessException {
		 T entity = null;
	        try {
	            entity = (T) mapper.getInfoByKey(key);
	        } catch (DataAccessException e) {
	            throw e;
	        }
	        return entity;
	}

}

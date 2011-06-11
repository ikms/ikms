/**
 * 
 */
package net.sf.ssi.service.impl;

import java.util.List;

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
	private UserMapper<T> mapper;

	@Override
	public T getInfoByKey(String key) throws DataAccessException {
		 T entity = null;
	        try {
	            entity = (T) mapper.getInfoByKey(key);
	        } catch (DataAccessException e) {
	            throw e;
	        }
	        return entity;
	}

	/* (non-Javadoc)
	 * @see net.sf.ssi.service.IUserService#save(net.sf.ssi.domain.User)
	 */
	@Override
	public void save(T entity) throws DataAccessException {
		try {
			mapper.saveEntity(entity);
		} catch (DataAccessException e) {
			throw e;
		}
		
	}
	/* (non-Javadoc)
	 * @see net.sf.ssi.service.IUserService#findAll()
	 */
	@Override
	public List<T> findAll() throws DataAccessException {
		List<T> entityList =null;
		try {
			entityList = mapper.findAll();
		} catch (DataAccessException e) {
			throw e;
		}
		return entityList;
	}

	public UserMapper<T> getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper<T> mapper) {
		this.mapper = mapper;
	}
}

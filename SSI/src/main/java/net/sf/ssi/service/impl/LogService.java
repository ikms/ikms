/**
 * 
 */
package net.sf.ssi.service.impl;

import java.util.List;

import javax.inject.Inject;

import net.sf.ssi.domain.Log;
import net.sf.ssi.mapper.LogMapper;
import net.sf.ssi.service.ILogService;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:25:35
 *
 */
@Service
public class LogService<T extends Log> implements ILogService<T> {
	
	@Inject
	//@Autowired //等同@Inject , 详见Spring3.0.x新特性之一。
	private LogMapper<T> mapper;

	@Override
	public T loadByKey(T argEntity) throws DataAccessException {
		 T entity = null;
	        try {
	            entity = mapper.loadByKey(argEntity);
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
			mapper.add(entity);
		} catch (DataAccessException e) {
			throw e;
		}
		
	}
	/* (non-Javadoc)
	 * @see net.sf.ssi.service.IUserService#findAll()
	 */
	@Override
	public List<T> find(T entity) throws DataAccessException {
		List<T> entityList =null;
		try {
			entityList = mapper.find(entity);
		} catch (DataAccessException e) {
			throw e;
		}
		return entityList;
	}
}

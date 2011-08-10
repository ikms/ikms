/**
 * 
 */
package net.sf.ssi.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:24:35
 * 
 */
@Transactional
public interface IUserService<T> {
	/**
	 * 获取Entity信息
	 * 
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public T loadByKey(T entity) throws DataAccessException;

	/**
	 * 持久化Entity
	 * 
	 * @param user
	 * @throws DataAccessException
	 */
	public void save(T entity) throws DataAccessException;

	/**
	 * 获取实体
	 * 
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> find(T entity) throws DataAccessException;
}

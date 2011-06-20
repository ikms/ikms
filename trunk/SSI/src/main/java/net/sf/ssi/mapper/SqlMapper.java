/**
 * 
 */
package net.sf.ssi.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:06:09
 * @param <T>
 *
 */
public interface SqlMapper<T> {
	//CRUD：Create，Read，Update，Delete
	/**
	 * 添加实体 
	 */
	public void add(T entity) throws DataAccessException;
	/**
	 * 编辑实体
	 */
	public void edit(T entity) throws DataAccessException;
	/**
	 * 移除实体
	 */
	public void remove(T entity) throws DataAccessException;
	/**
	 * 根据主键获取实体信息
	 */
	public T findByKey(T entity) throws DataAccessException;
	/**
	 * 获取全部实体
	 */
	public List<T> find(T entity) throws DataAccessException;
}

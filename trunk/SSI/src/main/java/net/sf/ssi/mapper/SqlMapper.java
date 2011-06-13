/**
 * 
 */
package net.sf.ssi.mapper;

import java.util.List;

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
	public void add(T entity);
	/**
	 * 编辑实体
	 */
	public void edit(T entity);
	/**
	 * 移除实体
	 */
	public void remove(T entity);
	/**
	 * 根据主键获取实体信息
	 */
	public T getInfoByKey(String key);
	/**
	 * 获取全部实体
	 */
	public List<T> find(T entity);
}

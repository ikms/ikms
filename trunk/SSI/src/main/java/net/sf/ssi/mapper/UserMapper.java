/**
 * 
 */
package net.sf.ssi.mapper;

import net.sf.ssi.domain.User;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:06:54
 * 
 */
public interface UserMapper extends SqlMapper {

	/**
	 * 根据主键获取实体信息
	 */
	public User getInfoByKey(String key);
}

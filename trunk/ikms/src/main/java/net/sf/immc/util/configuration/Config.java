/**
 * @(#)Config.java
 */
package net.sf.immc.util.configuration;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取Properties属性配置文件信息
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2010/01/26
 */
public class Config {

	private static Logger logger = LoggerFactory.getLogger(Config.class);
	
	private static String ConfigPath = "properties/config.properties";
	public Config() {
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key
	 * @return String类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static String getString(String key){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getString(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,如不存在默认返回defaultValue,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 			关键字Key
	 * @param defaultValue
	 * 			默认返回值
	 * @return String类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static String getString(String key,String defaultValue){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getString(key,defaultValue);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key
	 * @return Int类型的Value值,异常返回-1
	 * @version 0.1, 2010/01/27
	 */
	public static int getInt(String key){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getInt(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return -1;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,如不存在默认返回defaultValue,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 			关键字Key
	 * @param defaultValue
	 * 			默认返回值
	 * @return Int类型的Value值,异常返回-1
	 * @version 0.1, 2010/01/27
	 */
	public static int getInt(String key,int defaultValue){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getInt(key,defaultValue);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return -1;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key，默认使用英文逗号(,)分割
	 * @return String[]类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static String[] getStringArray(String key){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getStringArray(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的使用Char类型分隔符分割的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key
	 * @param delimiter
	 * 		char类型的Value值分隔符
	 * @return String[]类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static String[] getStringArray(String key,char delimiter){
		try {
			AbstractConfiguration.setDefaultListDelimiter(delimiter);
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getStringArray(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 从属性配置文件中获取关键字Key所对应的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key，默认使用英文逗号(,)分割
	 * @return List类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static List<?> getList(String key){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getList(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	/**
	 * 从属性配置文件中获取关键字Key所对应的使用Char类型分隔符分割的Value值,要求关键字Key保持全局唯一
	 * 
	 * @param key
	 * 		关键字Key
	 * @param delimiter
	 * 		char类型的Value值分隔符
	 * @return List类型的Value值,异常返回null
	 * @version 0.1, 2010/01/27
	 */
	public static List<?> getList(String key,char delimiter){
		try {
			AbstractConfiguration.setDefaultListDelimiter(delimiter);
			PropertiesConfiguration config = new PropertiesConfiguration(ConfigPath);
			return config.getList(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}

}

/**
 * @(#)Configuration.java
 * 
 * 涉及的jar包有：
 * 		commons-beanutils-1.8.2.jar
 * 		commons-codec-1.4.jar
 * 		commons-collections-3.2.1.jar
 * 		commons-configuration-1.6.jar
 * 		commons-digester-2.0.jar
 * 		commons-jxpath-1.3.jar
 * 		commons-lang-2.4.jar
 * 		commons-logging-1.1.1.jar
 */
/**
 * 只简单的封装了几个常用的类型，详细类型请见API文档 
 * http://commons.apache.org/configuration/apidocs/index.html
 * Apache configuration主页：http://commons.apache.org/configuration/
 */
package net.sf.immc.util.configuration;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置文件操作类Apache Commons实现
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2010/01/26
 */
public class ConfigApache {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigApache.class);
	
	
	/**
	 * 根据Properties文件路径,关键字Key,String类型Value值 更新关键字Key原有值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key
	 * @param value
	 * 			String类型的Value值
	 * @version 0.1,2010/01/27
	 */
	public static void changPropConfig(String filepath,String key,String value){
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(filepath);
			config.setProperty(key, value);
			config.save();
			config.setReloadingStrategy(new FileChangedReloadingStrategy()); //修改保存后自动重新加载
			
			//方法二
			//PropertiesConfiguration config = new PropertiesConfiguration(filepath);
			//config.setAutoSave(true);
			//config.setProperty(key, value); // the configuration is saved after this call
			//config.setReloadingStrategy(new FileChangedReloadingStrategy()); //修改保存后自动重新加载
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
		}
	}
	
	
	/**
	 * 根据Properties文件路径和关键字Key获取String类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key
	 * @return	String类型的Value值,异常返回null
	 * @version 0.1,2010/01/27
	 */
	public static String getStringPropConfig(String filepath,String key){
		try {
			//Configuration config = new PropertiesConfiguration(filepath);
			PropertiesConfiguration config = new PropertiesConfiguration(filepath);
			//config.setReloadingStrategy(new FileChangedReloadingStrategy()); //修改保存后自动重新加载
			return config.getString(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 根据Properties文件路径和关键字Key获取Int类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key
	 * @return	int类型的Value值,异常返回-1
	 * @version 0.1,2010/01/27
	 */
	public static int getIntPropConfig(String filepath,String key){
		try {
			Configuration config = new PropertiesConfiguration(filepath);
			return config.getInt(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return -1;
		}
	}
	
	/**
	 * 根据 <b>Properties文件路径, 关键字Key</b> 获取String[]类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key,默认使用英文逗号(,)分割的
	 * @return	String[]类型的Value值,异常返回null
	 * @version 0.1,2010/01/27
	 */
	public static String[] getStringArrayPropConfig(String filepath,String key){
		try {
			Configuration config = new PropertiesConfiguration(filepath);
			return config.getStringArray(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 根据 Properties文件路径,关键字Key,分隔符delimiter 获取String[]类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key
	 * @param delimiter
	 * 			char类型的Value值分隔符
	 * @return String[]类型的Value值,异常返回null
	 * @version 0.1,2010/01/27
	 */
	public static String[] getStringArrayPropConfig(String filepath,String key,char delimiter){
		try {
			//重新设置分隔符样式
			//示例：AbstractConfiguration.setDefaultListDelimiter('/');
			AbstractConfiguration.setDefaultListDelimiter(delimiter);
			
			Configuration config = new PropertiesConfiguration(filepath);
			return config.getStringArray(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 根据 <b>Properties文件路径, 关键字Key</b> 获取List类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key,默认使用英文逗号(,)分割的
	 * @return	List类型的Value值,异常返回null
	 * @version 0.1,2010/01/27
	 */
	public static List<?> getListPropConfig(String filepath,String key){
		try {
			Configuration config = new PropertiesConfiguration(filepath);
			return config.getList(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
	
	/**
	 * 根据 Properties文件路径,关键字Key,分隔符delimiter 获取List类型的Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径,注意默认为classpath的根目录 
	 * @param key
	 * 			关键字Key
	 * @param delimiter
	 * 			char类型的Value值分隔符
	 * @return List类型的Value值,异常返回null
	 * @version 0.1,2010/01/27
	 */
	public static List<?> getListPropConfig(String filepath,String key,char delimiter){
		try {
			//重新设置分隔符样式
			//示例：AbstractConfiguration.setDefaultListDelimiter('/');
			AbstractConfiguration.setDefaultListDelimiter(delimiter);
			Configuration config = new PropertiesConfiguration(filepath);
			return config.getList(key);
		} catch (ConfigurationException e) {
			//e.printStackTrace();
			logger.error(e.toString());
			return null;
		}
	}
}

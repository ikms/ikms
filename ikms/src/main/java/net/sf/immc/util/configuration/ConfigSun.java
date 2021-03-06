/**
 * @(#)ConfigSun.java
 */
package net.sf.immc.util.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置文件操作类Sun Java SDK实现(java.util.Properties)
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2010/01/26
 */
public class ConfigSun {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigSun.class);
	
	/**
	 * 根据Properties属性文件路径,关键字Key 获取关键字Key的String类型Value值
	 * 
	 * @param filepath
	 * 			Properties属性文件路径
	 * @param key
	 * 			关键字Key
	 * @return String类型的Value值
	 * @version 0.1,2010/01/27
	 */
	public static String getStringPropConfig(String filepath,String key){
		InputStream inputStream = ConfigSun.class.getResourceAsStream(filepath);
		Properties prop = new Properties();
		try {
			prop.load(inputStream);
			return prop.getProperty(key).trim();
		} catch (IOException e) {
			logger.error(e.toString());
			return null;
		}
		
	}
}

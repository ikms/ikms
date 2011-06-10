/**
 * @(#)SystemConfig.java
 */
package net.sf.immc.util.configuration;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 运行系统信息
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2010/01/26
 */
public class SystemConfig {
	
	/**操作系统名称*/
	public static final String OS_NAME = "os.name";//操作系统名称
	/**操作系统构架*/
	public static final String OS_ARCH = "os.arch";//操作系统构架
	/**操作系统版本*/
	public static final String OS_VERSION = "os.version";//操作系统版本
	/**Java 运行时环境版本 */
	public static final String JAVA_VERSION = "java.version";//Java 运行时环境版本 
	
	/**
	 * 根据关键字key获取运行系统信息
	 * 
	 * @param key
	 * 		关键字key
	 * @return String类型Value值
	 */
	public static String getSystemConfigProperties(String key){
		Properties props = System.getProperties();
		return props.getProperty(key);
		//方法二
		//return System.getProperty(key);
	}
	
	/**
	 * Java 运行时环境版本,类似1.5.0_22
	 * 
	 * @return String类型值
	 * @version 0.1,2010/01/27 
	 */
	public static String getJavaSDKVersion(){
		return getSystemConfigProperties(JAVA_VERSION);
	}
	
	/**
	 * 操作系统版本, 类似6.1
	 * 
	 * @return String类型值
	 * @version 0.1,2010/01/27 
	 */
	public static String getOSVersion(){
		return getSystemConfigProperties(OS_VERSION);
	}
	
	/**
	 * 操作系统名称,类似window 7
	 * 
	 * @return String类型值
	 * @version 0.1,2010/01/27 
	 */
	public static String getOSName(){
		return getSystemConfigProperties(OS_NAME);
	}
	
	/**
	 * 操作系统构架,类似x86
	 * 
	 * @return String类型值
	 * @version 0.1,2010/01/27 
	 */
	public static String getOSArch(){
		return getSystemConfigProperties(OS_ARCH);
	}
	
	public static void getSystemConfig() {
		Properties props = System.getProperties(); // 获得系统属性集
//		String osName = props.getProperty("os.name"); // 操作系统名称
//		System.out.print(osName+"\n");
//		String osArch = props.getProperty("os.arch"); // 操作系统构架
//		System.out.print(osArch+"\n");
//		String osVersion = props.getProperty("os.version"); // 操作系统版本
//		System.out.print(osVersion+"\n");
//		String javaversion = props.getProperty("java.version");//Java 运行时环境版本 
//		System.out.print(javaversion+"\n");
		
		// 枚举每个系统属性的名字   
		Enumeration<?> en = props.propertyNames();   
		for (; en.hasMoreElements();) {   
			// 得到名字   
			String propName = (String) en.nextElement();   
			// 得到属性值   
			String propValue = (String) props.get(propName);   
			System.out.println(propName + " = " + propValue);   
		}   
	}

}

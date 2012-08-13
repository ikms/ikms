/*
 * @(#)TomcatFactory.java
 * Copyright (C) 2003-2012 ikms.github.com All rights reserved
 */
package org.agileframework.web.tomcat;

import java.io.File;
import javax.servlet.ServletException;
import org.agileframework.web.ConstKey;
import org.apache.catalina.startup.Tomcat;

/**
 * 创建Tomcat Server的工厂类
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003 
 * @version 1.0, 09 August 2012
 */
public class TomcatFactory {
	
	private TomcatFactory() {
	}

	/**
	 * 创建用于开发运行调试的Tomcat Server, 默认以src/main/webapp为Web应用目录.
	 * @param port
	 * 			端口
	 * @param contextPath
	 * 			虚拟目录
	 * @param encoding
	 * 			默认连接编码，推荐使用utf-8
	 * @return tomcat
	 */
	public static Tomcat createServerInSource(int port, String contextPath, String encoding) {
		Tomcat tomcat = new Tomcat();
		try {
			tomcat.setPort(port);//设置端口
			tomcat.addWebapp(contextPath, new File(ConstKey.DEFAULT_WEBAPP_PATH).getAbsolutePath());
			tomcat.enableNaming();//执行这句才能支持JDNI查询
			tomcat.getConnector().setURIEncoding(encoding);//设置默认连接编码
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return tomcat;
	}
}

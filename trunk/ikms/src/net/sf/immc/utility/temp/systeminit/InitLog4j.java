/**
 * @(#) InitLog4j.java
 * 
 */
package net.sf.immc.utility.temp.systeminit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.sf.immc.utility.date.DateUtils;

//import org.apache.log4j.PropertyConfigurator;

/**
 * Log4j日志工具类初始化
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1,2010/01/27
 */
public class InitLog4j extends HttpServlet {
	
	private static final long serialVersionUID = 5810904439702370994L;
	
	public void init() throws ServletException {
		String prefix = getServletContext().getRealPath("/");
		String test = getServletContext().getRealPath("");
		String projectHome = getServletContext().getContextPath();
		//System.out.println(projectHome.substring(1));
		System.out.println("Log4J输出："+prefix);
		//System.out.println(test);

		System.setProperty("projectHome",projectHome.substring(1));
		System.setProperty("webappHome", test);
		System.setProperty("date", DateUtils.getCurrDateTime());
		String file = getServletConfig().getInitParameter("configPath");
		//System.out.println(prefix + file);
		// 从Servlet参数读取log4j的配置文件
		if (file != null) {
//			PropertyConfigurator.configure(prefix + file);
		}
	}

}

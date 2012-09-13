package org.agileframework.test.functional;

import org.agileframework.web.ConstKey;
import org.agileframework.web.jetty.JettyFactory;
import org.agileframework.web.tomcat.TomcatFactory;
import org.apache.catalina.startup.Tomcat;
import org.eclipse.jetty.server.Server;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车停止服务.
 * 
 * @author calvin
 */
public class QuickStartServer {

	public static final int PORT = 8080;
	public static final String CONTEXT = "/agile";
	public static final String BASE_URL = "http://localhost:8080/agile";
	public static final String[] TLD_JAR_NAMES = new String[] { "sitemesh", "spring-webmvc", "shiro-web",
		"joda-time-jsptags", "agile"};

	public static void main(String[] args) throws Exception {
		//设定Spring的profile
		System.setProperty("spring.profiles.active", "test");
		startJetty();
		//startTomcat();

	}

	public static void startTomcat() throws Exception {
		Tomcat tomcat = TomcatFactory.createServerInSource(PORT, CONTEXT, ConstKey.DEFAULT_ENCODING);
		tomcat.start();//启动tomcat服务
		//tomcat.getServer().await();//让服务器一直跑
		
		System.out.println("Server running at " + BASE_URL);
		System.out.println("Hit Enter in console to stop server");
		
		System.in.read();
		tomcat.stop();
		System.out.println("Server stopped");
	}

	public static void startJetty() throws Exception {
		
		//启动Jetty
		Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
		JettyFactory.setTldJarNames(server, TLD_JAR_NAMES);

		try {
			server.start();

			System.out.println("Server running at " + BASE_URL);
			System.out.println("Hit Enter to reload the application");

			//等待用户输入回车重载应用.
			while (true) {
				char c = (char) System.in.read();
				if (c == '\n') {
					JettyFactory.reloadContext(server);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}

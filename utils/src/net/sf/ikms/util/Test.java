package net.sf.ikms.util;

import net.sf.ikms.util.net.NetworkUtils;
import net.sf.ikms.util.os.OSUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(OSUtils.getProperty("os.name"));
		System.out.println(NetworkUtils.getAllLocalIP().toString());

	}

}

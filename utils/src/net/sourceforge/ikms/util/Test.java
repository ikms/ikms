package net.sourceforge.ikms.util;

import net.sourceforge.ikms.util.net.NetworkUtils;
import net.sourceforge.ikms.util.os.OSUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(OSUtils.getProperty("os.name"));
		System.out.println(NetworkUtils.getAllLocalIP().toString());

	}

}

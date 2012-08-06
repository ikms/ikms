package com.github.ikms.util;

import com.github.ikms.util.net.NetworkUtils;
import com.github.ikms.util.os.OSUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(OSUtils.getProperty("os.name"));
		System.out.println(NetworkUtils.getAllLocalIP().toString());

	}

}

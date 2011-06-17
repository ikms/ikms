/*
 * @(#)CommonUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ikms.util;

import java.util.UUID;

/**
 * Common utility method class
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since jdk 1.5
 * @version 1.0 , 2003/09/01
 * @date 2011-6-11 下午03:06:14
 * 
 */
public class CommonUtils {
	/**
	 * 生成标准的GUID字符串。
	 * @return 生成的惟一的标识字符串
	 * @since jdk 1.5
	 */
	public static String getGUID() {
		UUID uid = UUID.randomUUID();
		return uid.toString();
	}
}
/*
 * @(#)RandomUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ikms.util;

/**
 * 随机字符生成工具类
 * 
 * 
 * //产生如下格式的随机字符串“Are you W5B?”，可以自己指定临时占位符，这里用“#”； String
 * s5=RandomString.get("Are you ###?",'#');
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 07 August 2011
 * 
 */
public class RandomUtils {

	private static final String src_number = "0123456789";
	private static final String src_lower = "abcdefghijklmnopqrstuvwxyz";
	private static final String src_upper = src_lower.toUpperCase();
	private static final String src_hex_lower = "0123456789abcdef";
	private static final String src_hex_upper = src_hex_lower.toUpperCase();
	private static final String esc_char = "?";

	/**
	 * 产生由数字和大写字母组成的长度为size大小的随机字符串；
	 * 
	 * @param size
	 * @return
	 */
	public static String get(int size) {
		StringBuffer r = new StringBuffer(size);
		String src = src_number + src_upper;
		for (int i = 0; i < size; i++) {
			r.append(getRandomChar(src));
		}
		return r.toString();
	}

	/**
	 * 产生由数字和大写字符组成的指定格式的随机字符串，默认使用 英文的问号<code>?</code> 作为占位符.<br/>
	 * 
	 * <pre>
	 * eg：
	 * 想产生类似{E3-K91Z}这样的字符串，则格式为{??-????}。
	 * 调用的方法为 <code>RandomUtils.get("{??-????}");</code>
	 * </pre>
	 * 
	 * @param format
	 *            指定的格式字符串
	 * @return 符合指定格式的字符串
	 */
	public static String get(String format) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_number + src_upper;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(esc_char)) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	/**
	 * 产生由数字和大写字符组成的指定格式和指定占位符的随机字符串.<br/>
	 * 
	 * <pre>
	 * eg：
	 * 想产生类似  Are you W5B? 这样的字符串，其中W5B为随机生成的，则格式为Are you ###?。
	 * 调用的方法为 <code>RandomUtils.get("Are you ###?","#");</code>
	 * </pre>
	 * 
	 * @param format
	 *            指定的格式字符串
	 * @param esc
	 *            指定的占位符字符串
	 * @return 符合指定格式和指定占位符的字符串
	 */
	public static String get(String format, char esc) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_number + src_upper;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(String.valueOf(esc))) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	/**
	 * 产生由数字组成的长度为size大小的随机字符串
	 * 
	 * @param size
	 * @return
	 */
	public static String getNum(int size) {
		StringBuffer r = new StringBuffer(size);
		String src = src_number;
		for (int i = 0; i < size; i++) {
			r.append(getRandomChar(src));
		}
		return r.toString();
	}

	public static String getNum(String format) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_number;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(esc_char)) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	public static String getNum(String format, char esc) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_number;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(String.valueOf(esc))) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	/**
	 * 产生由十六进制字符组成长度为size大小的随机字符串
	 * 
	 * @param size
	 * @return
	 */
	public static String getHex(int size) {
		StringBuffer r = new StringBuffer(size);
		String src = src_hex_upper;
		for (int i = 0; i < size; i++) {
			r.append(getRandomChar(src));
		}
		return r.toString();
	}

	public static String getHex(String format) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_hex_upper;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(esc_char)) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	public static String getHex(String format, char esc) {
		StringBuffer r = new StringBuffer(format.length());
		String src = src_hex_upper;
		for (int i = 0; i < format.length(); i++) {
			String curr = String.valueOf(format.charAt(i));
			if (curr.equalsIgnoreCase(String.valueOf(esc))) {
				r.append(getRandomChar(src));
			} else {
				r.append(curr);
			}
		}
		return r.toString();
	}

	private static final String getRandomChar(String src) {
		if (null == src || "".equals(src)) {
			return "";
		}
		return String.valueOf((src.charAt((int) (Math.random() * src.length()))));
	}
}

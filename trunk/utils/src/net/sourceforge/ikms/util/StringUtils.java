/*
 * @(#)StringUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */
package net.sourceforge.ikms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作公共类
 * 
 * <pre>
 * Java 5.0 dependent
 * </pre>
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 28 December 2010
 * @version 1.0, 28 December 2010
 * @version 1.1, 11 June 2011
 * @see org.apache.commons.lang3.StringUtils
 * 
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	/**
     * 字符数组转换为字符串
     * @param bytes
     * @return
     */
    public static String bytesToString(byte[] bytes){
        return new String(bytes);
    }

	/**
	 * StringUtils.isBlank为true则返回toStr。否则返回str
	 * 
	 * @param str
	 * @param toStr
	 * @return
	 * @author oxidy
	 * @version 1.0,2010-10-24
	 */
	public static String isBlankToStr(String str, String toStr) {
		if (isBlank(str)) {
			str = toStr;
		}
		return str;
	}

	/**
	 * StringUtils.isBlank为true则返回""。否则返回str
	 * 
	 * @param str
	 * @return
	 * @author oxidy
	 * @version 1.0,2010-10-24
	 */
	public static String isBlankToStr(String str) {
		return isBlankToStr(str, "");
	}

	/**
	 * 判断一个字符串是否为数字。
	 * 
	 * @param str
	 *            要判断的字符串。
	 * @return true 是数字，false 非数字
	 * @version 1.0,2010/01/21
	 */
	public static boolean isNumeric(String str) {
		if (str.trim().equals(""))
			return false;
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断一个字符串是否为全是字母
	 * 
	 * @param str
	 *            要判断的字符串
	 * @return true 是字母串 false 不是字母串
	 * @version 1.0,2010/01/21
	 */
	public static boolean isLetter(String str) {
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher isStr = pattern.matcher(str);
		if (!isStr.matches()) {
			return false;
		} else
			return true;
	}

	/**
	 * 如字符串str为空,则将字符串str替换成toStr输出,否则输出原字符串str
	 * 
	 * @param str
	 *            要判断的字符串
	 * @param message
	 *            要替换的toStr信息
	 * @return 如果不为空，则返回str； 如果为空，则返回toStr
	 * @version 1.0, 2010/01/05
	 */
	public static String isEmptyToStr(String str, String toStr) {
		if (str.trim().length() <= 0) {
			return toStr;
		} else {
			return str;
		}
	}

	/**
	 * 如字符串str为NULL,则将字符串str替换成toStr输出,否则输出原字符串str
	 * 
	 * @param str
	 *            要判断的字符串
	 * @param message
	 *            要替换的toStr信息
	 * @return 如果不为NULL，则返回str； 如果为NULL，则返回toStr
	 * @version 1.0, 2010/01/05
	 */
	public static String isNullToStr(String str, String toStr) {
		if (str == null) {
			return toStr;
		} else {
			return str;
		}
	}

	/**
	 * 获取字符的子串，如果原字符串长度大于子串，那么后边将加上字符串"..."
	 * 
	 * @param inputStr
	 *            传入的字符串
	 * @param beginIndex
	 *            开始的位置，从0开始
	 * @param length
	 *            子串的长度
	 * @return 字串
	 */
	public static String subStringWith3Point(String inputStr, int beginIndex, int length) {
		int strLength = inputStr.length();
		if (beginIndex >= strLength) {
			return "";
		}
		if (beginIndex + length >= strLength) {
			return inputStr.substring(beginIndex);
		}
		return inputStr.substring(beginIndex, beginIndex + length - 1) + "...";
	}

	/**
	 * 转换字符串的内码.
	 * 
	 * @param inputStr
	 *            输入的字符串
	 * @param sourceEncoding
	 *            源字符集名称
	 * @param targetEncoding
	 *            目标字符集名称
	 * @return 转换结果, 如果有错误发生, 则返回原来的值
	 */
	public static String changeEncoding(String inputStr, String sourceEncoding, String targetEncoding) {
		if (inputStr == null || inputStr.equals("")) {
			return inputStr;
		}
		try {
			byte[] bytes = inputStr.getBytes(sourceEncoding);
			return new String(bytes, targetEncoding);
		} catch (Exception ex) {
		}
		return inputStr;
	}
	/**
	 * 获取字符的子串，
	 * @param string
	 *            传入的字符串
	 * @param beginIndex
	 *            开始的位置，从0开始
	 * @param length
	 *            子串的长度
	 * @return 字串
	 */
    public static String substring(String string, int beginIndex, int length) {
        int strLength = string.length();
        if (beginIndex >= strLength) {
            return "";
        }
        if (beginIndex + length >= strLength) {
            return string.substring(beginIndex);
        }
        return string.substring(beginIndex, beginIndex + length);
    }

}

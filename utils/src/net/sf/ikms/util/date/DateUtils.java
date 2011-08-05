/*
 * @(#)DateUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ikms.util.date;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间日期工具类
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 20 June 2011
 * @Depends  slf4j-log4j12-1.6.x.jar <br/>slf4j-api-1.6.x.jar
 * 
 */
public class DateUtils {
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	/**
	 * 获取当前系统时间，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return java.util.Date类型时间
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static Date getCurrentDateTimeDate() {
		// 方法一
		Date dateTime = new Date();
		return formatTypeDate(dateTime, DateConst.standard_format);
		// 方法二
		// return formatTypeDate(currentTime,
		// standard_format,Locale.SIMPLIFIED_CHINESE);
		// 方法三
		// return coverStringToDate(getCurrentDateTime(), standard_format);
	}

	/**
	 * 获取当前系统时间，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String类型字符串日期
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String getCurrentDateTime() {
		Date dateTime = new Date();
		return formatTypeString(dateTime, DateConst.standard_format, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 获取当前系统时间，格式为：yyyy-MM-dd
	 * 
	 * @return java.util.Date类型时间
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static Date getCurrentDateDate() {
		Date dateTime = getCurrentDateTimeDate();
		return formatTypeDate(dateTime, DateConst.standard_simple_format);
	}

	/**
	 * 获取当前系统时间，格式为：yyyy-MM-dd
	 * 
	 * @return String类型字符串日期
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String getCurrentDate() {
		Date dateTime = new Date();
		return formatTypeString(dateTime, DateConst.standard_simple_format);
	}

	/**
	 * 获取时间，格式为：HH:mm:ss
	 * 
	 * @return String类型时间
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String getTime() {
		Date dateTime = new Date();
		return formatTypeString(dateTime, DateConst.time_format);

	}

	/**
	 * 获取当前年月，并格式化为：yyyyMM 形式。
	 * 
	 * @return String类型，yyyyMM 形式。
	 */
	public static String getCurrentYearMonths() {
		Date dateTime = new Date();
		return formatTypeString(dateTime, "yyyyMM");
	}

	/**
	 * 根据 <b>格式化样式</b> 格式化java.util.Date类型时间
	 * 
	 * @param dateTimeDate
	 *            待格式化的java.uitl.Date类型时间
	 * @param pattern
	 *            格式化模式
	 * @return 格式化后的java.util.Date类型时间
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static Date formatTypeDate(Date dateTimeDate, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String dateString = format.format(dateTimeDate);
		ParsePosition pos = new ParsePosition(0);
		Date dateTime = format.parse(dateString, pos);
		return dateTime;
	}

	/**
	 * 根据 <b>格式化样式及Locale类型字符串</b> 格式化java.util.Date类型时间
	 * 
	 * @param dateTimeDate
	 *            待格式化的java.uitl.Date类型时间
	 * @param pattern
	 *            格式化模式
	 * @param locale
	 *            java.util.Locale类型字符串,时区
	 * @return 格式化后的java.util.Date类型时间
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static Date formatTypeDate(Date dateTimeDate, String pattern, Locale locale) {
		SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
		String dateString = format.format(dateTimeDate);
		try {
			Date dateTime = format.parse(dateString);
			return dateTime;
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 将<b>java.util.Date类型时间</b> 根据 <b>格式化样式及时区序号</b> 格式化为<b>字符串</b>
	 * 
	 * @param dateTimeDate
	 *            待格式化的java.uitl.Date类型时间
	 * @param pattern
	 *            格式化模式
	 * @param locale
	 *            java.util.Locale类型字符串,时区
	 * @return 格式化后的java.util.Date类型字符串
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String formatTypeString(Date dateTimeDate, String pattern, Locale locale) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
			return format.format(dateTimeDate);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 将<b>java.util.Date类型时间</b> 根据 <b>格式化样式</b> 格式化为<b>字符串</b>,默认时区：简体中文
	 * 
	 * @param dateTimeDate
	 *            待格式化的java.uitl.Date类型时间
	 * @param pattern
	 *            格式化模式
	 * @return 格式化后的java.util.Date类型字符串
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String formatTypeString(Date dateTimeDate, String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.SIMPLIFIED_CHINESE);
			return format.format(dateTimeDate);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * String类型字符串转换为Date类型日期，并按照pattern模式格式化时间
	 * 
	 * @param strDate
	 *            待转换的时间字符串
	 * @param pattern
	 *            转换后时间的模式
	 * @return 转换并按照pattern模式格式化后的java.util.Date类型日期
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static Date convertStringToDate(String strDate, String pattern) {
		if (strDate == null || "".equals(strDate)) {
			strDate = "1900-01-01 00:00:00";
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.parse(strDate);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 按照 <b>pattern模式</b> 格式化Date类型日期并将Date类型日期转换为String类型字符串，默认时区：简体中文
	 * 
	 * @param date
	 *            待转换的Date类型日期
	 * @param pattern
	 *            转换时格式化时间的模式
	 * @return 格式化并转化为String类型的字符串
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String convertDateToString(Date date, String pattern) {
		// 方法一
		// SimpleDateFormat format = new SimpleDateFormat(pattern);
		// return format.format(date);
		// 方法二
		return formatTypeString(date, pattern);
	}

	/**
	 * 按照 <b>pattern模式</b> 及 <b>时区</b> 格式化Date类型日期并将Date类型日期转换为String类型字符串
	 * 
	 * @param date
	 *            待转换的Date类型日期
	 * @param pattern
	 *            转换时格式化时间的模式
	 * @return 格式化并转化为String类型的字符串
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String convertDateToString(Date date, String pattern, Locale locale) {
		return formatTypeString(date, pattern, locale);
	}

	/**
	 * <b>标准格式日期类型字符串</b> 格式化为 <b>非标准格式日期类型字符串</b><BR/>
	 * yyyy-MM-dd HH:mm:ss 转换为 yyyyMMddHHmmss
	 * 
	 * @param strDateTime
	 *            标准格式日期类型字符串，例如：yyyy-MM-dd HH:mm:ss
	 * @return 非标准格式日期类型字符串，例如：yyyyMMddHHmmss
	 * @version 1.0
	 * @date 2010/01/26
	 */
	public static String formatStrDateTime(String strDateTime) {
		strDateTime = strDateTime.replaceAll(":", "");
		strDateTime = strDateTime.replaceAll("-", "");
		strDateTime = strDateTime.replaceAll(" ", "");
		return strDateTime;
	}
}

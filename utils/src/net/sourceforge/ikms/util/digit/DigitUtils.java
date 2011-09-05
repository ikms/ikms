/*
 * @(#)DigitUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sourceforge.ikms.util.digit;

/**
 * 数字相关工具类 (Integer,Float,Double,etc)
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 05 August 2011
 * 
 */
public class DigitUtils {
	/**
	 * 将规范float类型的数据，保留2位小数,用户页面显示使用
	 * 
	 * @param param
	 *            待转换的浮点数
	 * @return 字符串型的两位小数
	 */
	public static String getStrFormatTwoPoint(float param) {
		param += 0.001;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		return df.format(param);
	}

	/**
	 * 将规范float类型的数据，保留2位小数
	 * 
	 * @param param
	 *            待转换的浮点数
	 * @return 两位小数的浮点数
	 */
	public static float getFormatTwoPoint(float param) {
		param += 0.001;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		return Float.parseFloat(df.format(param));
	}

	/**
	 * 将规范double类型的数据，保留2位小数
	 * 
	 * @param param
	 *            要保留的double型数据
	 * @return 两位小数的double数
	 * @author lifw20080116
	 * @modify lifw20080401
	 */
	public static double getFormatTwoPoint(double param) {
		param += 0.001;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		return Double.parseDouble(df.format(param));
	}
}

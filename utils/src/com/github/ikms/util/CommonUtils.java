/*
 * @(#)CommonUtils.java
 * Copyright (C) 2003-2011 ikms.github.com All rights reserved
 */

package com.github.ikms.util;

import java.util.UUID;

/**
 * Common utility method class
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since jdk 1.5
 * @since 11 June 2011
 * 
 */
public class CommonUtils {
	/**
	 * 生成标准的36位GUID字符串。
	 * @return 生成的惟一的标识字符串
	 * @since jdk 1.5
	 */
	public static String getGUID() {
		UUID uid = UUID.randomUUID();
		return uid.toString();
	}
	/**
	 * 生成大写字母的36位GUID字符串。
	 * @return 生成的惟一的标识字符串
	 * @since jdk 1.5
	 */
	public static String getUpperCase36GUID() {
		UUID uid = UUID.randomUUID();
		return uid.toString().toUpperCase();
	}
	/**
	 * 生成大写字母的32位GUID字符串。
	 * @return 生成的惟一的标识字符串
	 * @since jdk 1.5
	 */
	public static String getUpperCase32GUID() {
		UUID uid = UUID.randomUUID();
		return uid.toString().replace("-", "").toUpperCase();
	}
	/**
     * 人民币转化成大写
     * <p><pre>
     * rmbSmallToBig(100.00)="壹佰圆整"
     * rmbSmallToBig(10.25)="壹拾圆贰角伍分"
     * </pre>
     * 
     * @param value
     * @return 大写人民币字符
     */
    public static String rmbSmallToBig(double value) {
        char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
        char[] vunit = { '万', '亿' }; // 段名表示
        char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
        long midVal = (long) (value * 100); // 转化成整形
        String valStr = String.valueOf(midVal); // 转化成字符串
        
        String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
        String rail = valStr.substring(valStr.length() - 2); // 取小数部分
        
        String prefix = ""; // 整数部分转化的结果
        String suffix = ""; // 小数部分转化的结果
        // 处理小数点后面的数
        if (rail.equals("00")) { // 如果小数部分为0
            suffix = "整";
        } else {
            suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
        }
        // 处理小数点前面的数
        char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
        char zero = '0'; // 标志'0'表示出现过0
        byte zeroSerNum = 0; // 连续出现0的次数
        for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
            int idx = (chDig.length - i - 1) % 4; // 取段内位置
            int vidx = (chDig.length - i - 1) / 4; // 取段位置
            if (chDig[i] == '0') { // 如果当前字符是0
                zeroSerNum++; // 连续0次数递增
                if (zero == '0') { // 标志
                    zero = digit[0];
                } else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
                    prefix += vunit[vidx - 1];
                    zero = '0';
                }
                continue;
            }
            zeroSerNum = 0; // 连续0次数清零
            if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
                prefix += zero;
                zero = '0';
            }
            prefix += digit[chDig[i] - '0']; // 转化该数字表示
            if (idx > 0)
                prefix += hunit[idx - 1];
            if (idx == 0 && vidx > 0) {
                prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
            }
        }
        if (prefix.length() > 0)
            prefix += '圆'; // 如果整数部分存在,则有圆的字样
        return prefix + suffix; // 返回正确表示 
    }
}

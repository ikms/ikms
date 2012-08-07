/*
 * @(#)DataTypeConvertUtils.java
 * Copyright (C) 2003-2011 ikms.github.com All rights reserved
 */
package com.github.ikms.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;

/**
 * 数据类型转换
 * @author <b>oxidy</b>, Copyright &#169; 2003 
 * @version 1.0, 06 August 2012
 *
 */
public class DataTypeConvertUtils {
	/**
	* 将Blob类型数据转换为String类型数据
	* @param BlobContent
	* @return String
	* @author wangl
	*/
	public static String blobToString(Blob BlobContent) {
		byte[] bytes; //BLOB临时存储字节数组
		String stringContent = ""; //返回字符串
		int i = 1; //循环变量
		long BlobLength; //BLOB字段长度
		try {
			BlobLength = BlobContent.length(); //获取BLOB长度
			if (BlobLength == 0) { //如果为空，返回空值
				return "";
			} else { //处理BLOB为字符串
				while (i < BlobLength) { //循环处理字符串转换，每次1024；Oracle字符串限制最大4k
					bytes = BlobContent.getBytes(i, 1024);
					i = i + 1024;
					stringContent = stringContent + new String(bytes, "gb2312");
				}
				return stringContent;
			}
		} catch (Exception e) { //oracle异常捕获
			e.printStackTrace();
		}
		return stringContent;
	}
	/**
     * 将String类型数据转化为byte[]类型数据
     * 
     * @param stringContent
     *            String
     * @return byte[]
     * @version 1.0 2009-12-09
     */
    public static byte[] stringToByteArray(String stringContent) {
        return stringContent.getBytes();
    }
    /**
     * 将byte[]类型数据转化为String类型数据，默认使用UTF-8编码转换
     * @param byteArrayContent
     * @param encoding
     * @return String
     * @version 1.2 2012-08-06 增加默认编码<BR/>
     * 			1.1	2009-12-15 修正param==null时出错的问题<BR/>
     * 			1.0 2009-12-09
     */
    public static String byteArrayToString(byte[] byteArrayContent,String encoding) {
        String stringContent = null;
        if (byteArrayContent == null) {
            return stringContent = "";
        } else {
        	if (encoding==null || "".equals(encoding)) {
				encoding = "utf-8";
			}
            ByteArrayInputStream in = new ByteArrayInputStream(byteArrayContent);
            int len = in.available();
            byte[] buffin = new byte[len];
            try {
                in.read(buffin);
                in.close();
                stringContent = new String(buffin, 0, len, encoding);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringContent;
    }

	/**
	 * 将Array字符类型数据成String数据类型
	 * @param arrayContent
	 * @return stringContent
	 */
	public static String arrayToString(String[] arrayContent) {
		String stringContent = "";
		for (int i = 0; i < arrayContent.length; i++) {
			stringContent = stringContent + arrayContent[i] + ",";
		}
		return stringContent;
	}
}

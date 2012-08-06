/*
 * @(#)CryptUtils.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package com.github.ikms.util.security;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密相关公共方法
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 05 August 2011
 * 
 */
public class CryptUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CryptUtils.class);
	
	/**
	 * 获取MD5加密后的字符串
	 * @param password
	 *            需要加密的字符串
	 * @return 加密后的字符串
	 */
    public static String getMD5(String password) {
        MessageDigest md5;
        try {
        	// 生成一个MD5加密计算摘要ܼ
            md5 = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md5.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String pwd = new BigInteger(1, md5.digest()).toString(16);
            return pwd;
        } catch (Exception e) {
        	logger.error(e.getMessage());
        }
        return password;
    }

}

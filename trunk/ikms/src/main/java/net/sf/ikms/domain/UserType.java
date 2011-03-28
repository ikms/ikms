/**
 * @(#)UserType.java
 * Copyright ikms.sourceforge.net 2003-2011
 */
package net.sf.ikms.domain;

import java.io.Serializable;

/**
 * 用户类型信息表
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003-2011
 * @version 0.1,2011-3-2
 */
public class UserType implements Serializable {

	private static final long serialVersionUID = -4203662686904023142L;
	/**
	 * 用户类型编码
	 */
	private String userTypeCode = "";
	/**
	 * 用户类型名称
	 */
	private String userTypeName = "";

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userTypeCode == null) ? 0 : userTypeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		if (userTypeCode == null) {
			if (other.userTypeCode != null)
				return false;
		} else if (!userTypeCode.equals(other.userTypeCode))
			return false;
		return true;
	}

	// ==========常量==========//
	/**
	 * 普通用户
	 */
	public static final String UT_NORMAL = "001";
	/**
	 * 统一认证用户
	 */
	public static final String UT_UA = "002";
	/**
	 * 管理员用户
	 */
	public static final String UT_ADMIN = "009";
	/**
	 * VIP用户
	 */
	public static final String UT_VIP = "003";
	/**
	 * 扩展系统用户
	 */
	public static final String UT_EXT = "008";

}

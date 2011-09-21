/*
 * @(#)Account.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户帐户
 * 
 * @author zhangyj
 * @version 1.0
 * @date 2011-6-21 上午11:32:29
 * 
 */
public class Account implements Serializable {

	private static final long serialVersionUID = -5365857692691004394L;

	private Long accountNum;			// 用户数字帐号,唯一
	private String accountId;		// 用户帐户,唯一
	private String accountName;		// 用户昵称,唯一
	private String accountPassword;	// 帐户密码
	private String accountEmail;	// 帐户邮箱,唯一
	private String accountStatus;	// 帐户状态
	private Date createDate;		// 新增帐户日期
	
	/**
	 * @return the accountNum
	 */
	public Long getAccountNum() {
		return accountNum;
	}
	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the accountPassword
	 */
	public String getAccountPassword() {
		return accountPassword;
	}
	/**
	 * @param accountPassword the accountPassword to set
	 */
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	/**
	 * @return the accountEmail
	 */
	public String getAccountEmail() {
		return accountEmail;
	}
	/**
	 * @param accountEmail the accountEmail to set
	 */
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	/**
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}
	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
}

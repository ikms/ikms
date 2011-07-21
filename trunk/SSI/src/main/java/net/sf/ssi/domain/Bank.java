/*
 * @(#)Bank.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.domain;

import java.io.Serializable;

/**
 * 银行基本信息
 * 
 * @author zhangyj
 * @version 0.1, 2011-7-21 上午10:09:52
 * 
 */
public class Bank implements Serializable {

	private static final long serialVersionUID = 8640137421075033185L;
	
	private int bankId;				//银行ID
	private String bankName;		//银行名称
	private String bankURI;			//银行网址
	private String bankLogo;		//银行Logo
	private String bankShortNameCN;	//银行中文简称
	private String bankShortNameEN; //银行英文简称
	private String bankPhone;		//银行电话
	
	
	/**
	 * @return the bankId
	 */
	public int getBankId() {
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the bankURI
	 */
	public String getBankURI() {
		return bankURI;
	}
	/**
	 * @param bankURI the bankURI to set
	 */
	public void setBankURI(String bankURI) {
		this.bankURI = bankURI;
	}
	/**
	 * @return the bankLogo
	 */
	public String getBankLogo() {
		return bankLogo;
	}
	/**
	 * @param bankLogo the bankLogo to set
	 */
	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}
	/**
	 * @return the bankShortNameCN
	 */
	public String getBankShortNameCN() {
		return bankShortNameCN;
	}
	/**
	 * @param bankShortNameCN the bankShortNameCN to set
	 */
	public void setBankShortNameCN(String bankShortNameCN) {
		this.bankShortNameCN = bankShortNameCN;
	}
	/**
	 * @return the bankShortNameEN
	 */
	public String getBankShortNameEN() {
		return bankShortNameEN;
	}
	/**
	 * @param bankShortNameEN the bankShortNameEN to set
	 */
	public void setBankShortNameEN(String bankShortNameEN) {
		this.bankShortNameEN = bankShortNameEN;
	}
	/**
	 * @return the bankPhone
	 */
	public String getBankPhone() {
		return bankPhone;
	}
	/**
	 * @param bankPhone the bankPhone to set
	 */
	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}
}

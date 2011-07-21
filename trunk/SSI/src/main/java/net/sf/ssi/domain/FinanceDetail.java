/*
 * @(#)FinanceDetail.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务明细信息表
 * 
 * @author zhangyj
 * @version 0.1, 2011-7-21 上午10:53:09
 * 
 */
public class FinanceDetail implements Serializable {

	private static final long serialVersionUID = 6559700660750608274L;

	private int financeDetailId;//财务明细信息表
	private Finance finance;//账户信息
	private Date date; // 交易日期
	private String address;// 交易场所
	private String desc;// 业务摘要
	private String inString;// 收入金额
	private String outString;// 支出金额
	private BigDecimal balance=new BigDecimal("0");// 余额
	private String description;// 备注
	
	
	/**
	 * @return the financeDetailId
	 */
	public int getFinanceDetailId() {
		return financeDetailId;
	}
	/**
	 * @param financeDetailId the financeDetailId to set
	 */
	public void setFinanceDetailId(int financeDetailId) {
		this.financeDetailId = financeDetailId;
	}
	/**
	 * @return the finance
	 */
	public Finance getFinance() {
		return finance;
	}
	/**
	 * @param finance the finance to set
	 */
	public void setFinance(Finance finance) {
		this.finance = finance;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the inString
	 */
	public String getInString() {
		return inString;
	}
	/**
	 * @param inString the inString to set
	 */
	public void setInString(String inString) {
		this.inString = inString;
	}
	/**
	 * @return the outString
	 */
	public String getOutString() {
		return outString;
	}
	/**
	 * @param outString the outString to set
	 */
	public void setOutString(String outString) {
		this.outString = outString;
	}
	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

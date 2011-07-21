/*
 * @(#)Finance.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务基本情况信息表
 * 
 * @author zhangyj
 * @version 0.1, 2011-7-21 上午10:03:03
 * 
 */
public class Finance implements Serializable {

	private static final long serialVersionUID = -5691095010477806247L;
	
	private int financeId;		//财务编号,唯一
	private User user;			//用户
	private Bank bank;			//银行
	private String bankCard;	//银行卡号,唯一
	private String bankAccount;	//银行账户,唯一
	private String bankCardType;	//银行卡(账户)类型
	private String alias;		//账户别名,主要是：工资，消费，储蓄，理财等等类似的简短文字,唯一
	private Date openDate;	//开户时间
	private BigDecimal lineOfCredit = new BigDecimal("0");//银行信用额度
	private BigDecimal balance=new BigDecimal("0"); //账户当前余额
	
	
	/**
	 * @return the financeId
	 */
	public int getFinanceId() {
		return financeId;
	}
	/**
	 * @param financeId the financeId to set
	 */
	public void setFinanceId(int financeId) {
		this.financeId = financeId;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	/**
	 * @return the bankCard
	 */
	public String getBankCard() {
		return bankCard;
	}
	/**
	 * @param bankCard the bankCard to set
	 */
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	/**
	 * @return the bankAccount
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * @return the bankCardType
	 */
	public String getBankCardType() {
		return bankCardType;
	}
	/**
	 * @param bankCardType the bankCardType to set
	 */
	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * @return the lineOfCredit
	 */
	public BigDecimal getLineOfCredit() {
		return lineOfCredit;
	}
	/**
	 * @param lineOfCredit the lineOfCredit to set
	 */
	public void setLineOfCredit(BigDecimal lineOfCredit) {
		this.lineOfCredit = lineOfCredit;
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
}

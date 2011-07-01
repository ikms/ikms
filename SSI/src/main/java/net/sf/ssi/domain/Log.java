/**
 * @(#)Log.java
 * Copyright ikms.sf.net 2003-2011
 */
package net.sf.ssi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志
 * 
 * @author <b>oxidy</b>,Copyright &#169;2003
 * @author zhangyj
 * @version 1.0
 * @date 2011-7-1
 */
public class Log implements Serializable {

	private static final long serialVersionUID = 1912548725856406592L;

	private String logId; 			// 日志编码,唯一
	private Account account;		// 日志所有者
	private String logTitle; 		// 日志主题(标题)
	private String logContent; 		// 日志内容
	private Date createDate; 		// 日志创建日期
	private Date lastEditDate; 		// 日志最后编辑日期
	
	//==============================================//
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getLogTitle() {
		return logTitle;
	}
	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
}

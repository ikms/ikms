/**
 * 
 */
package net.sf.ssi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户信息
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午09:56:45
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 4486069573596403045L;

	private String userId;			// 用户编码
	private String userAccount;		// 用户账号
	private String userName;		// 用户名
	private String userPassword;	// 密码
	private String nickName;		// 昵称
	private String userSource;		// 用户来源
//	private UserType userTypeCode;	// 用户类型
	private Date createDate;		// 创建时间
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserSource() {
		return userSource;
	}
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}

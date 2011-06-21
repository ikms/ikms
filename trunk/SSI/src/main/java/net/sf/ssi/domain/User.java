/**
 * 
 */
package net.sf.ssi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * 
 * @author zhangyj
 * @version 1.0
 * @date 2011-5-25 上午09:56:45
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userSource the userSource to set
	 */
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	/**
	 * @return the userSource
	 */
	public String getUserSource() {
		return userSource;
	}
	
}

/**
 * 
 */
package net.sf.ssi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午09:56:45
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 4486069573596403045L;

	private String userId;		// 用户编码
	private String userName;	// 用户名
	private String password;	// 密码
	private String nickName;	// 昵称
	private String userSource;	// 用户来源
	private Date createDate;	// 创建时间

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

}

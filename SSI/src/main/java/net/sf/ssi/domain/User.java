/**
 * 
 */
package net.sf.ssi.domain;

import java.io.Serializable;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午09:56:45
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 4486069573596403045L;

	private String userId;
	private String userName;
	private String password;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

//	@Override
//	public String toString() {
//		return "userId=" + this.userId + ", userName=" + this.userName + ", password=" + this.password;
//	}

}

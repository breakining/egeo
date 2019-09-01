package com.egeo.back.user.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:23
 */
public class PassWordVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 新密码
	 */
	
	private String newPassword;

	/**
	 * 确认新密码
	 */
	private String confirmNewPassword;

	/**
	 * 老密码
	 */
	private String oldPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}



}
	
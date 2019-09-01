package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-05-08 15:16:17
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 邮箱地址
	 */
	private String mail;

	/**
	 * 删除标记
	 */
	private Integer delFlag;

	/**
	 * 二维码
	 */
	private String qrcode;

	/**
	 * 
	 */
	private String token;

	/**
	 * 加密盐
	 */
	private String salt;

	/**
	 * 最新一次更新盐的时间
	 */
	private Date updateSalt;

	/**
	 * 用户所在公司的id
	 */
	private String companyId;

	public String getId() {
		return id;
	}

	/**
	 * 编号
	 * @param id 编号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 登录名
	 * @return 登录名
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 登录名
	 * @param loginName 登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 密码
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 姓名
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 手机
	 * @return 手机
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机
	 * @param mobile 手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 邮箱地址
	 * @return 邮箱地址
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 邮箱地址
	 * @param mail 邮箱地址
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 删除标记
	 * @return 删除标记
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 删除标记
	 * @param delFlag 删除标记
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 二维码
	 * @return 二维码
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * 二维码
	 * @param qrcode 二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 
	 * @return 
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 
	 * @param token 
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 加密盐
	 * @return 加密盐
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 加密盐
	 * @param salt 加密盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 最新一次更新盐的时间
	 * @return 最新一次更新盐的时间
	 */
	public Date getUpdateSalt() {
		return updateSalt;
	}

	/**
	 * 最新一次更新盐的时间
	 * @param updateSalt 最新一次更新盐的时间
	 */
	public void setUpdateSalt(Date updateSalt) {
		this.updateSalt = updateSalt;
	}
	/**
	 * 用户所在公司的id
	 * @return 用户所在公司的id
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * 用户所在公司的id
	 * @param companyId 用户所在公司的id
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
	
package com.egeo.basics.user.po;


import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class UserLoginPO {


	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;	

	/**
	 * 用户名
	 */
	private String username;	

	/**
	 * 登陆结果
	 */
	private Integer loginResult;	

	/**
	 * 登陆时间
	 */
	private Date loginTime;	

	/**
	 * ip
	 */
	private String ip;	

	/**
	 * 浏览器信息
	 */
	private String browser;	

	/**
	 * 公司id
	 */
	private Long companyId;	

	/**
	 * 平台id
	 */
	private Long platformId;	

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 用户id
	 * @return 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 * @param userId 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 登陆结果
	 * @return 登陆结果
	 */
	public Integer getLoginResult() {
		return loginResult;
	}

	/**
	 * 登陆结果
	 * @param loginResult 登陆结果
	 */
	public void setLoginResult(Integer loginResult) {
		this.loginResult = loginResult;
	}

	/**
	 * 登陆时间
	 * @return 登陆时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 登陆时间
	 * @param loginTime 登陆时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * ip
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip
	 * @param ip ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 浏览器信息
	 * @return 浏览器信息
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * 浏览器信息
	 * @param browser 浏览器信息
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * 公司id
	 * @return 公司id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 公司id
	 * @param companyId 公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * 平台id
	 * @return 平台id
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 平台id
	 * @param platformId 平台id
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}
}
	
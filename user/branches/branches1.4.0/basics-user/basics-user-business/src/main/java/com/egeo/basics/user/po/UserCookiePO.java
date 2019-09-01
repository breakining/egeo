package com.egeo.basics.user.po;


import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-18 18:50:29
 */
public class UserCookiePO {


	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;	

	/**
	 * cookie 名称
	 */
	private String cookieName;	

	/**
	 * cookie值
	 */
	private String cookieValue;	

	/**
	 * 域
	 */
	private String domain;	

	/**
	 * 路径
	 */
	private String path;	

	/**
	 * 过期时间
	 */
	private Date expirationTime;	

	/**
	 * 公司id
	 */
	private Long companyId;	

	/**
	 * 平台id
	 */
	private Long platformId;	

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;	

	/**
	 * 修改时间:更新时数据库会自动set值
	 */
	private Date updateTime;	

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
	 * cookie 名称
	 * @return cookie 名称
	 */
	public String getCookieName() {
		return cookieName;
	}

	/**
	 * cookie 名称
	 * @param cookieName cookie 名称
	 */
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	/**
	 * cookie值
	 * @return cookie值
	 */
	public String getCookieValue() {
		return cookieValue;
	}

	/**
	 * cookie值
	 * @param cookieValue cookie值
	 */
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	/**
	 * 域
	 * @return 域
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 域
	 * @param domain 域
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * 路径
	 * @return 路径
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 路径
	 * @param path 路径
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 过期时间
	 * @return 过期时间
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}

	/**
	 * 过期时间
	 * @param expirationTime 过期时间
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
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

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 * @return 创建时间:创建记录时数据库会自动set值
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 * @param createTime 创建时间:创建记录时数据库会自动set值
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 修改时间:更新时数据库会自动set值
	 * @return 修改时间:更新时数据库会自动set值
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间:更新时数据库会自动set值
	 * @param updateTime 修改时间:更新时数据库会自动set值
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
	
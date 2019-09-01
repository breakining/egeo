package com.egeo.back.user.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 登录名
	 */

	private String loginName;		 

    private String name;

	/**
	 * 密码
	 */

	private String password;		 
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

	private Long companyId;		 
	/**
	 * 
	 */

	private Integer isAvailable;		 
	/**
	 * 逻辑删除字段 0 正常 1 已删除
	 */

	private Integer isDeleted;		 
	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */

	private Date createTime;		 
	/**
	 * 修改时间:更新时数据库会自动set值
	 */

	private Date updateTime;		 

    // 创建开始时间
    private String beginTime;

    // 创建结束时间
    private String finishTime;
    
    /**
	 * 用户所在platform
	 */
	private Long platformId;
	
	public Long getId() {
		return id;
	}

	/**
	 * 编号
	 * @param id 编号
	 */
	public void setId(Long id) {
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
	 * 
	 * @return 
	 */
	public Integer getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 
	 * @param isAvailable 
	 */
	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}	
	/**
	 * 逻辑删除字段 0 正常 1 已删除
	 * @return 逻辑删除字段 0 正常 1 已删除
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 逻辑删除字段 0 正常 1 已删除
	 * @param isDeleted 逻辑删除字段 0 正常 1 已删除
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getName() {
		return name;
}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
	
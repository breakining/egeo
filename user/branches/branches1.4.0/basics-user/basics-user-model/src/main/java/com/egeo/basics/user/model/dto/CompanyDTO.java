package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-12-05 12:05:16
 */
public class CompanyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 公司名称
	 */
	private String companyName;	

	/**
	 * 公司庆祝时间
	 */
	private Date companyCelebrateTime;	

	/**
	 * 企业邮箱后缀
	 */
	private String companyMailSuffix;	

	/**
	 * 注册状态：1、非开放式注册
	 */
	private Integer registrationStatus;	

	/**
	 * 公司描述
	 */
	private String companyContent;	

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;	

	/**
	 * 修改时间:更新时数据库会自动set值
	 */
	private Date updateTime;	

	/**
	 * 平台id
	 */
	private Long platformId;	

	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 公司名称
	 * @return 公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 公司名称
	 * @param companyName 公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 公司庆祝时间
	 * @return 公司庆祝时间
	 */
	public Date getCompanyCelebrateTime() {
		return companyCelebrateTime;
	}

	/**
	 * 公司庆祝时间
	 * @param companyCelebrateTime 公司庆祝时间
	 */
	public void setCompanyCelebrateTime(Date companyCelebrateTime) {
		this.companyCelebrateTime = companyCelebrateTime;
	}
	/**
	 * 企业邮箱后缀
	 * @return 企业邮箱后缀
	 */
	public String getCompanyMailSuffix() {
		return companyMailSuffix;
	}

	/**
	 * 企业邮箱后缀
	 * @param companyMailSuffix 企业邮箱后缀
	 */
	public void setCompanyMailSuffix(String companyMailSuffix) {
		this.companyMailSuffix = companyMailSuffix;
	}
	/**
	 * 注册状态：1、非开放式注册
	 * @return 注册状态：1、非开放式注册
	 */
	public Integer getRegistrationStatus() {
		return registrationStatus;
	}

	/**
	 * 注册状态：1、非开放式注册
	 * @param registrationStatus 注册状态：1、非开放式注册
	 */
	public void setRegistrationStatus(Integer registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	/**
	 * 公司描述
	 * @return 公司描述
	 */
	public String getCompanyContent() {
		return companyContent;
	}

	/**
	 * 公司描述
	 * @param companyContent 公司描述
	 */
	public void setCompanyContent(String companyContent) {
		this.companyContent = companyContent;
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
	
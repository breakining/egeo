package com.egeo.basics.user.po;


import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class PlatformPO {


	private Long id;

	/**
	 * 平台名
	 */
	private String name;	

	/**
	 * 是否可用
	 */
	private Integer isAvailable;	

	/**
	 * 
	 */
	private String remark;	

	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;	

	/**
	 * 修改时间:更新时数据库会自动set值
	 */
	private Date updateTime;	

	/**
	 * 用户所在公司的id
	 */
	private Long companyId;	

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
	 * 平台名
	 * @return 平台名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 平台名
	 * @param name 平台名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 是否可用
	 * @return 是否可用
	 */
	public Integer getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 是否可用
	 * @param isAvailable 是否可用
	 */
	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * 
	 * @return 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 
	 * @param remark 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 用户所在公司的id
	 * @return 用户所在公司的id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 用户所在公司的id
	 * @param companyId 用户所在公司的id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
	
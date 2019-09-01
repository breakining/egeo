package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class PlatformRoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 平台编号
	 */
	private Long platformId;	

	/**
	 * 角色编号
	 */
	private Long roleId;	

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
	 * 平台编号
	 * @return 平台编号
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 平台编号
	 * @param platformId 平台编号
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}
	/**
	 * 角色编号
	 * @return 角色编号
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色编号
	 * @param roleId 角色编号
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
	
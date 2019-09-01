package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-18 18:50:29
 */
public class UserRoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 用户编号
	 */
	private Long userId;	

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
	 * 用户编号
	 * @return 用户编号
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户编号
	 * @param userId 用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
}
	
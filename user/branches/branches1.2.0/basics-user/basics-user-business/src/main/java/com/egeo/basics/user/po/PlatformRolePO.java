package com.egeo.basics.user.po;

import java.io.Serializable;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:14
 */
public class PlatformRolePO implements Serializable {
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
}
	
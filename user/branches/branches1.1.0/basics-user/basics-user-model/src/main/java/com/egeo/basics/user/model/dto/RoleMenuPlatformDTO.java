package com.egeo.basics.user.model.dto;

import java.io.Serializable;

/**
 * 
 * @author xiaping
 * @date 2017-05-09 18:03:10
 */
public class RoleMenuPlatformDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 平台编号
	 */
	private String platformId;

	/**
	 * 角色编号
	 */
	private String roleId;

	/**
	 * 菜单编号
	 */
	private String menuId;

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 平台编号
	 * @return 平台编号
	 */
	public String getPlatformId() {
		return platformId;
	}

	/**
	 * 平台编号
	 * @param platformId 平台编号
	 */
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	/**
	 * 角色编号
	 * @return 角色编号
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * 角色编号
	 * @param roleId 角色编号
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 菜单编号
	 * @return 菜单编号
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 菜单编号
	 * @param menuId 菜单编号
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
	
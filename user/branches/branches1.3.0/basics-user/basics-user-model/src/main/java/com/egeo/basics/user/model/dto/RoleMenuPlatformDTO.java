package com.egeo.basics.user.model.dto;

import java.io.Serializable;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:45:25
 */
public class RoleMenuPlatformDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * 平台编号
	 */
	private Integer platformId;

	/**
	 * 角色编号
	 */
	private String roleId;

	/**
	 * 菜单编号
	 */
	private String menuId;

	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 平台编号
	 * @return 平台编号
	 */
	public Integer getPlatformId() {
		return platformId;
	}

	/**
	 * 平台编号
	 * @param platformId 平台编号
	 */
	public void setPlatformId(Integer platformId) {
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
	
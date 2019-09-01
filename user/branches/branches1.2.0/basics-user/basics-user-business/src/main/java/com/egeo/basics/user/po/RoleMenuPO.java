package com.egeo.basics.user.po;

import java.io.Serializable;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:15
 */
public class RoleMenuPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 角色编号
	 */
	private Long roleId;

	/**
	 * 菜单编号
	 */
	private Long menuId;

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
	 * 菜单编号
	 * @return 菜单编号
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 菜单编号
	 * @param menuId 菜单编号
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
	
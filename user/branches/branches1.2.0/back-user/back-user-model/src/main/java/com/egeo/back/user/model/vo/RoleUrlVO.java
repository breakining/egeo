package com.egeo.back.user.model.vo;

import java.io.Serializable;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class RoleUrlVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 
	 */
	private Long roleId;

	/**
	 * 
	 */
	private Long urlId;

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
	 * 
	 * @return 
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 
	 * @param roleId 
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 
	 * @return 
	 */
	public Long getUrlId() {
		return urlId;
	}

	/**
	 * 
	 * @param urlId 
	 */
	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}
}
	
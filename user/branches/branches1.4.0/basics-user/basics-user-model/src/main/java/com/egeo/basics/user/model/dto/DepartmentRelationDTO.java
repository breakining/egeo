package com.egeo.basics.user.model.dto;

import java.io.Serializable;

/**
 * 
 * @author min
 * @date 2017-12-03 04:17:14
 */
public class DepartmentRelationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 父id
	 */
	private Long pid;	

	/**
	 * 部门id
	 */
	private Long departmentId;	

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
	 * 父id
	 * @return 父id
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * 父id
	 * @param pid 父id
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 部门id
	 * @return 部门id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 部门id
	 * @param departmentId 部门id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}
	
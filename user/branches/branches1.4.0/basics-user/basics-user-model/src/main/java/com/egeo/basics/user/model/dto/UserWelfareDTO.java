package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-15 18:32:41
 */
public class UserWelfareDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 用户表主表id
	 */
	private Long userId;	

	/**
	 * 部门id
	 */
	private Long departmentId;	

	/**
	 * 入职时间
	 */
	private Date entryTime;	

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
	 * 用户表主表id
	 * @return 用户表主表id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户表主表id
	 * @param userId 用户表主表id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	/**
	 * 入职时间
	 * @return 入职时间
	 */
	public Date getEntryTime() {
		return entryTime;
	}

	/**
	 * 入职时间
	 * @param entryTime 入职时间
	 */
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
}
	
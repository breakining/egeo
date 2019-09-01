package com.egeo.basics.user.condition;

import java.util.Date;

import com.egeo.basics.user.po.UserExtendPO;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:45:26
 */
public class UserExtendCondition extends UserExtendPO {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户所在公司的id
	 */
	private Long companyId;	
	
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 部门id
	 */
	private Long departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 入职时间
	 */
	private Date entryTime;	
	/**
	 * 邮箱地址
	 */
	private String mail;	

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
	
	
	
	
}
	
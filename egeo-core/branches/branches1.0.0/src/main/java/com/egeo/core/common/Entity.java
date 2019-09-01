package com.egeo.core.common;

import java.util.Date;

public class Entity {
	

	/**
	 * 版本号:默认0,每次更新+1
	 */
	private Integer versionNo;

	/**
	 * 创建人ID
	 */
	private Long createUserid;

	/**
	 * 创建人姓名
	 */
	private String createUsername;

	/**
	 * 创建人IP
	 */
	private String createUserip;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 最后修改人ID
	 */
	private Long updateUserid;

	/**
	 * 最后修改人姓名
	 */
	private String updateUsername;

	/**
	 * 最后修改人IP
	 */
	private String updateUserip;

	/**
	 * 最后修改时间
	 */
	private Date updateTime;






	/**
	 * 版本号:默认0,每次更新+1
	 * @return 版本号:默认0,每次更新+1
	 */
	public Integer getVersionNo() {
		return versionNo;
	}

	/**
	 * 版本号:默认0,每次更新+1
	 * @param versionNo 版本号:默认0,每次更新+1
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * 创建人ID
	 * @return 创建人ID
	 */
	public Long getCreateUserid() {
		return createUserid;
	}

	/**
	 * 创建人ID
	 * @param createUserid 创建人ID
	 */
	public void setCreateUserid(Long createUserid) {
		this.createUserid = createUserid;
	}

	/**
	 * 创建人姓名
	 * @return 创建人姓名
	 */
	public String getCreateUsername() {
		return createUsername;
	}

	/**
	 * 创建人姓名
	 * @param createUsername 创建人姓名
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	/**
	 * 创建人IP
	 * @return 创建人IP
	 */
	public String getCreateUserip() {
		return createUserip;
	}

	/**
	 * 创建人IP
	 * @param createUserip 创建人IP
	 */
	public void setCreateUserip(String createUserip) {
		this.createUserip = createUserip;
	}

	/**
	 * 
	 * @return 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 
	 * @param createTime 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 最后修改人ID
	 * @return 最后修改人ID
	 */
	public Long getUpdateUserid() {
		return updateUserid;
	}

	/**
	 * 最后修改人ID
	 * @param updateUserid 最后修改人ID
	 */
	public void setUpdateUserid(Long updateUserid) {
		this.updateUserid = updateUserid;
	}

	/**
	 * 最后修改人姓名
	 * @return 最后修改人姓名
	 */
	public String getUpdateUsername() {
		return updateUsername;
	}

	/**
	 * 最后修改人姓名
	 * @param updateUsername 最后修改人姓名
	 */
	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

	/**
	 * 最后修改人IP
	 * @return 最后修改人IP
	 */
	public String getUpdateUserip() {
		return updateUserip;
	}

	/**
	 * 最后修改人IP
	 * @param updateUserip 最后修改人IP
	 */
	public void setUpdateUserip(String updateUserip) {
		this.updateUserip = updateUserip;
	}

	/**
	 * 最后修改时间
	 * @return 最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 最后修改时间
	 * @param updateTime 最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	
	

}

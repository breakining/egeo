package com.egeo.basics.user.po;


import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-18 18:50:29
 */
public class RolePO {


	private Long id;

	/**
	 * 角色名称
	 */
	private String name;	

	/**
	 * 英文名称
	 */
	private String enname;	

	/**
	 * 角色类型
	 */
	private String roleType;	

	/**
	 * 是否系统数据
	 */
	private String isSys;	

	/**
	 * 是否可用
	 */
	private Integer useable;	

	/**
	 * 备注信息
	 */
	private String remarks;	

	/**
	 * 
	 */
	private Long platformId;	

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
	 * 编号
	 * @param id 编号
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 角色名称
	 * @return 角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 角色名称
	 * @param name 角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 英文名称
	 * @return 英文名称
	 */
	public String getEnname() {
		return enname;
	}

	/**
	 * 英文名称
	 * @param enname 英文名称
	 */
	public void setEnname(String enname) {
		this.enname = enname;
	}

	/**
	 * 角色类型
	 * @return 角色类型
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * 角色类型
	 * @param roleType 角色类型
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * 是否系统数据
	 * @return 是否系统数据
	 */
	public String getIsSys() {
		return isSys;
	}

	/**
	 * 是否系统数据
	 * @param isSys 是否系统数据
	 */
	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}

	/**
	 * 是否可用
	 * @return 是否可用
	 */
	public Integer getUseable() {
		return useable;
	}

	/**
	 * 是否可用
	 * @param useable 是否可用
	 */
	public void setUseable(Integer useable) {
		this.useable = useable;
	}

	/**
	 * 备注信息
	 * @return 备注信息
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注信息
	 * @param remarks 备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 
	 * @return 
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 
	 * @param platformId 
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
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
	
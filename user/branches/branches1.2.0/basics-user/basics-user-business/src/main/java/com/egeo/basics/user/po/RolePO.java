package com.egeo.basics.user.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:15
 */
public class RolePO implements Serializable {
	private static final long serialVersionUID = 1L;

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
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 备注信息
	 */
	private String remarks;

	/**
	 * 删除标记
	 */
	private Integer delFlag;

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
	 * 创建者
	 * @return 创建者
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 创建者
	 * @param createBy 创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 创建时间
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间
	 * @param createDate 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新者
	 * @return 更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 更新者
	 * @param updateBy 更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 更新时间
	 * @return 更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新时间
	 * @param updateDate 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * 删除标记
	 * @return 删除标记
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 删除标记
	 * @param delFlag 删除标记
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}
	
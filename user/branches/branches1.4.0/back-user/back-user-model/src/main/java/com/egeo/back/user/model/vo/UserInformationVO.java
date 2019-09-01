package com.egeo.back.user.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-30 14:56:28
 */
public class UserInformationVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 消息标题
	 */
	private String headline;
	/**
	 * 消息内容
	 */
	private String headlineContent;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 发送用户id
	 */
	private Long dispatchUserId;
	/**
	 * 用户消息状态：0、未读 1、已读
	 */
	private Integer type;
	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;
	/**
	 * 修改时间:更新时数据库会自动set值
	 */
	private Date updateTime;
	/**
	 * 平台id
	 */
	private Long platformId;

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
	 * 消息标题
	 * @return 消息标题
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * 消息标题
	 * @param headline 消息标题
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}	
	/**
	 * 消息内容
	 * @return 消息内容
	 */
	public String getHeadlineContent() {
		return headlineContent;
	}

	/**
	 * 消息内容
	 * @param headlineContent 消息内容
	 */
	public void setHeadlineContent(String headlineContent) {
		this.headlineContent = headlineContent;
	}	
	/**
	 * 用户id
	 * @return 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 * @param userId 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}	
	/**
	 * 发送用户id
	 * @return 发送用户id
	 */
	public Long getDispatchUserId() {
		return dispatchUserId;
	}

	/**
	 * 发送用户id
	 * @param dispatchUserId 发送用户id
	 */
	public void setDispatchUserId(Long dispatchUserId) {
		this.dispatchUserId = dispatchUserId;
	}	
	/**
	 * 用户消息状态：0、未读 1、已读
	 * @return 用户消息状态：0、未读 1、已读
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 用户消息状态：0、未读 1、已读
	 * @param type 用户消息状态：0、未读 1、已读
	 */
	public void setType(Integer type) {
		this.type = type;
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
	/**
	 * 平台id
	 * @return 平台id
	 */
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * 平台id
	 * @param platformId 平台id
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}	
}
	
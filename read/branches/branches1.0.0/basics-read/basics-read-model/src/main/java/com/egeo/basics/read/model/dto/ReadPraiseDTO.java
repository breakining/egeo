package com.egeo.basics.read.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-16 13:07:20
 */
public class ReadPraiseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 用户真实姓名 
	 */
	private String userName;

	/**
	 * 主题id
	 */
	private Long topicId;	

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
	 * 主题id
	 * @return 主题id
	 */
	public Long getTopicId() {
		return topicId;
	}

	/**
	 * 主题id
	 * @param topicId 主题id
	 */
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
}
	
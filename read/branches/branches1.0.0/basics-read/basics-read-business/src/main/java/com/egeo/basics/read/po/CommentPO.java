package com.egeo.basics.read.po;


import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-17 13:18:41
 */
public class CommentPO {


	private Long id;

	/**
	 * 主题id
	 */
	private Long topicId;	

	/**
	 * 主题type
	 */
	private Integer topicType;	

	/**
	 * 评论内容
	 */
	private String content;	

	/**
	 * 评论用户id
	 */
	private Long fromUid;	

	/**
	 * 用户名称
	 */
	private String userName;	

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
	 * 主题type
	 * @return 主题type
	 */
	public Integer getTopicType() {
		return topicType;
	}

	/**
	 * 主题type
	 * @param topicType 主题type
	 */
	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}

	/**
	 * 评论内容
	 * @return 评论内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 评论内容
	 * @param content 评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 评论用户id
	 * @return 评论用户id
	 */
	public Long getFromUid() {
		return fromUid;
	}

	/**
	 * 评论用户id
	 * @param fromUid 评论用户id
	 */
	public void setFromUid(Long fromUid) {
		this.fromUid = fromUid;
	}

	/**
	 * 用户名称
	 * @return 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名称
	 * @param userName 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	
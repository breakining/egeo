package com.egeo.basics.read.po;


import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-16 16:55:43
 */
public class TopicPO {


	private Long id;
	
	private Long companyId;

	/**
	 * 图书名称
	 */
	private String booksName;	

	/**
	 * 主题标题
	 */
	private String topicHeadline;	

	/**
	 * 主题内容
	 */
	private String topicContent;	

	/**
	 * 主题type
	 */
	private Integer topicType;	

	/**
	 * 主题封面
	 */
	private String topicCover;	

	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 书籍作者
	 */
	private String author;
	
	/**
	 * 出版社
	 */
	private String publishingHouse;

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
	 * 图书名称
	 * @return 图书名称
	 */
	public String getBooksName() {
		return booksName;
	}

	/**
	 * 图书名称
	 * @param booksName 图书名称
	 */
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}

	/**
	 * 主题标题
	 * @return 主题标题
	 */
	public String getTopicHeadline() {
		return topicHeadline;
	}

	/**
	 * 主题标题
	 * @param topicHeadline 主题标题
	 */
	public void setTopicHeadline(String topicHeadline) {
		this.topicHeadline = topicHeadline;
	}

	/**
	 * 主题内容
	 * @return 主题内容
	 */
	public String getTopicContent() {
		return topicContent;
	}

	/**
	 * 主题内容
	 * @param topicContent 主题内容
	 */
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
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
	 * 主题封面
	 * @return 主题封面
	 */
	public String getTopicCover() {
		return topicCover;
	}

	/**
	 * 主题封面
	 * @param topicCover 主题封面
	 */
	public void setTopicCover(String topicCover) {
		this.topicCover = topicCover;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
	
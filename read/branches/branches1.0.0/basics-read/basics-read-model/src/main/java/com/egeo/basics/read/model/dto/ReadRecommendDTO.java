package com.egeo.basics.read.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-12-05 11:59:00
 */
public class ReadRecommendDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 所属公司的id
	 */
	private Long companyId;

	/**
	 * 书籍名称
	 */
	private String booksName;	

	/**
	 * 书籍图片
	 */
	private String booksPicture;	

	/**
	 * 作者
	 */
	private String author;	

	/**
	 * 出版社
	 */
	private String publishingHouse;	

	/**
	 * 跳转到京东自营图书的相关书籍详情页面url
	 */
	private String skipUrl;	

	/**
	 * 排序
	 */
	private Integer sortValue;	

	/**
	 * 推荐语
	 */
	private String recommendLanguage;	

	/**
	 * 书籍状态:0、待上架 1、已上架 2、已下架
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
	 * 书籍名称
	 * @return 书籍名称
	 */
	public String getBooksName() {
		return booksName;
	}

	/**
	 * 书籍名称
	 * @param booksName 书籍名称
	 */
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}
	/**
	 * 书籍图片
	 * @return 书籍图片
	 */
	public String getBooksPicture() {
		return booksPicture;
	}

	/**
	 * 书籍图片
	 * @param booksPicture 书籍图片
	 */
	public void setBooksPicture(String booksPicture) {
		this.booksPicture = booksPicture;
	}
	/**
	 * 作者
	 * @return 作者
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 作者
	 * @param author 作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 出版社
	 * @return 出版社
	 */
	public String getPublishingHouse() {
		return publishingHouse;
	}

	/**
	 * 出版社
	 * @param publishingHouse 出版社
	 */
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	/**
	 * 跳转到京东自营图书的相关书籍详情页面url
	 * @return 跳转到京东自营图书的相关书籍详情页面url
	 */
	public String getSkipUrl() {
		return skipUrl;
	}

	/**
	 * 跳转到京东自营图书的相关书籍详情页面url
	 * @param skipUrl 跳转到京东自营图书的相关书籍详情页面url
	 */
	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
	/**
	 * 排序
	 * @return 排序
	 */
	public Integer getSortValue() {
		return sortValue;
	}

	/**
	 * 排序
	 * @param sortValue 排序
	 */
	public void setSortValue(Integer sortValue) {
		this.sortValue = sortValue;
	}
	/**
	 * 推荐语
	 * @return 推荐语
	 */
	public String getRecommendLanguage() {
		return recommendLanguage;
	}

	/**
	 * 推荐语
	 * @param recommendLanguage 推荐语
	 */
	public void setRecommendLanguage(String recommendLanguage) {
		this.recommendLanguage = recommendLanguage;
	}
	/**
	 * 书籍状态:0、待上架 1、已上架 2、已下架
	 * @return 书籍状态:0、待上架 1、已上架 2、已下架
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 书籍状态:0、待上架 1、已上架 2、已下架
	 * @param type 书籍状态:0、待上架 1、已上架 2、已下架
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
	
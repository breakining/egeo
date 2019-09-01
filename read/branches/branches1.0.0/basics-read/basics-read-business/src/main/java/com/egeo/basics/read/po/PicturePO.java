package com.egeo.basics.read.po;


import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-11-15 10:31:08
 */
public class PicturePO {


	private Long id;

	/**
	 * 
	 */
	private String name;	

	/**
	 * 
	 */
	private String url;	

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
	 * 
	 * @param id 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return 
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url 
	 */
	public void setUrl(String url) {
		this.url = url;
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
	
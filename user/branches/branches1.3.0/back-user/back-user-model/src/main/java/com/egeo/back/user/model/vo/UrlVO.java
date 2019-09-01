package com.egeo.back.user.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class UrlVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 
	 */

	private String url;		 
	/**
	 * 
	 */

	private String name;		 
	/**
	 * 
	 */

	private String description;		 
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
	/**
	 * 用户所在公司的id
	 */

	private Long companyId;		 
	
	private boolean checked;

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
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}	

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

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
	/**
	 * 用户所在公司的id
	 * @return 用户所在公司的id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 用户所在公司的id
	 * @param companyId 用户所在公司的id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}	
}
	
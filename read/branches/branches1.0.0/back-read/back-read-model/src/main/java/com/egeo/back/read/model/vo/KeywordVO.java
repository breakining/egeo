package com.egeo.back.read.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author min
 * @date 2017-12-02 11:49:47
 */
public class KeywordVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 关键词内容
	 */
	private String keywordContent;
	/**
	 * 创建时间:创建记录时数据库会自动set值
	 */
	private Date createTime;

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
	 * 关键词内容
	 * @return 关键词内容
	 */
	public String getKeywordContent() {
		return keywordContent;
	}

	/**
	 * 关键词内容
	 * @param keywordContent 关键词内容
	 */
	public void setKeywordContent(String keywordContent) {
		this.keywordContent = keywordContent;
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
}
	
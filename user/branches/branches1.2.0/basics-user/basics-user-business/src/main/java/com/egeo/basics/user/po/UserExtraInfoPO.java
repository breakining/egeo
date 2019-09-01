package com.egeo.basics.user.po;

import java.io.Serializable;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:16
 */
public class UserExtraInfoPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 
	 */
	private String tableName;

	/**
	 * 
	 */
	private Integer isExist;

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
	public String getTableName() {
		return tableName;
	}

	/**
	 * 
	 * @param tableName 
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 
	 * @return 
	 */
	public Integer getIsExist() {
		return isExist;
	}

	/**
	 * 
	 * @param isExist 
	 */
	public void setIsExist(Integer isExist) {
		this.isExist = isExist;
	}
}
	
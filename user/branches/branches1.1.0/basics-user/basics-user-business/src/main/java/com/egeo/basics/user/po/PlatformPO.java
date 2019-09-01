package com.egeo.basics.user.po;



/**
 * 
 * @author xiaping
 * @date 2017-05-05 16:13:27
 */
public class PlatformPO {


	private String id;

	/**
	 * 平台名
	 */
	private String name;

	/**
	 * 是否可用
	 */
	private Integer isAvailable;

	/**
	 * 是否已经被删除
	 */
	private Integer delFlag;

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 平台名
	 * @return 平台名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 平台名
	 * @param name 平台名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 是否可用
	 * @return 是否可用
	 */
	public Integer getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 是否可用
	 * @param isAvailable 是否可用
	 */
	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * 是否已经被删除
	 * @return 是否已经被删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 是否已经被删除
	 * @param delFlag 是否已经被删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}
	
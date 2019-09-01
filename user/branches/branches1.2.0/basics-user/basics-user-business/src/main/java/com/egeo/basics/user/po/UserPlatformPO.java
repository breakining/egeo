package com.egeo.basics.user.po;

import java.io.Serializable;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:16
 */
public class UserPlatformPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

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
	
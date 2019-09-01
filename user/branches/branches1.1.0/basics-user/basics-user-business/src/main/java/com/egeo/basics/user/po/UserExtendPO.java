package com.egeo.basics.user.po;



/**
 * 
 * @author xiaping
 * @date 2017-05-09 09:56:03
 */
public class UserExtendPO {


	private String id;

	/**
	 * 
	 */
	private Integer sex;

	/**
	 * 
	 */
	private String nickname;

	/**
	 * 
	 */
	private String headPicUrl;

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
	 * 
	 * @return 
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 
	 * @param sex 
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 
	 * @return 
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 
	 * @param nickname 
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 
	 * @return 
	 */
	public String getHeadPicUrl() {
		return headPicUrl;
	}

	/**
	 * 
	 * @param headPicUrl 
	 */
	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}
}
	
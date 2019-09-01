package com.egeo.back.user.model.vo;

import java.io.Serializable;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class UserExtendVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 匿名
	 */
	private String nickname;

	/**
	 * 头像
	 */
	private String headPicUrl;
	
	private String name;

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
	 * 性别
	 * @return 性别
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 性别
	 * @param sex 性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 匿名
	 * @return 匿名
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 匿名
	 * @param nickname 匿名
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 头像
	 * @return 头像
	 */
	public String getHeadPicUrl() {
		return headPicUrl;
	}

	/**
	 * 头像
	 * @param headPicUrl 头像
	 */
	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	
}
	
package com.egeo.back.user.model.vo;

/**
 * 用于客户端部门成员列表展示的userVo
 * 
 * @author GRACIA
 *
 */
public class DepartmentUserVO {

	private Long userId;
	private String nickName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}

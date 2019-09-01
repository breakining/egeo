package com.egeo.back.user.model.entity;



/**
 * 加密实体
 * @author xuc
 * @time 2016年5月27日 下午3:49:16
 * @description
 */
public class EncryptEntity {
	private Long userId;//用户id
/*	private String oldFSalt;//原前端盐
	private String newFSalt;//新前端盐
	private Integer oldFVersion;//原前端算法版本
	private Integer newFVersion;//新前端算法版本
*/	private String oldBSalt;//原后端盐
	private String newBSalt;//新后端盐
	private Integer oldBVersion;//原后端算法版本
	private Integer newBVersion;//新后端算法版本
	private String oldPassword;//原密码
	private String newPassword;//新密码
	
	
	private String fEncryptFlag;//前端算法启用标志
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOldBSalt() {
		return oldBSalt;
	}
	public void setOldBSalt(String oldBSalt) {
		this.oldBSalt = oldBSalt;
	}
	public String getNewBSalt() {
		return newBSalt;
	}
	public void setNewBSalt(String newBSalt) {
		this.newBSalt = newBSalt;
	}
	public Integer getOldBVersion() {
		return oldBVersion;
	}
	public void setOldBVersion(Integer oldBVersion) {
		this.oldBVersion = oldBVersion;
	}
	public Integer getNewBVersion() {
		return newBVersion;
	}
	public void setNewBVersion(Integer newBVersion) {
		this.newBVersion = newBVersion;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getfEncryptFlag() {
		return fEncryptFlag;
	}
	public void setfEncryptFlag(String fEncryptFlag) {
		this.fEncryptFlag = fEncryptFlag;
	}
	
	
}

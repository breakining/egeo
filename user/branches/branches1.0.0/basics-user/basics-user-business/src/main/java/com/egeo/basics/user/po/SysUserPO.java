package com.egeo.basics.user.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-05-03 17:36:41
 */
public class SysUserPO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * 归属公司
	 */
	private String companyId;

	/**
	 * 归属部门
	 */
	private String officeId;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 工号
	 */
	private String no;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 用户类型
	 */
	private String userType;

	/**
	 * 用户头像
	 */
	private String photo;

	/**
	 * 最后登陆IP
	 */
	private String loginIp;

	/**
	 * 最后登陆时间
	 */
	private Date loginDate;

	/**
	 * 是否可登录
	 */
	private String loginFlag;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 备注信息
	 */
	private String remarks;

	/**
	 * 删除标记
	 */
	private String delFlag;

	/**
	 * 二维码
	 */
	private String qrcode;

	/**
	 * 个性签名
	 */
	private String sign;

	public String getId() {
		return id;
	}

	/**
	 * 编号
	 * @param id 编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 归属公司
	 * @return 归属公司
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * 归属公司
	 * @param companyId 归属公司
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 归属部门
	 * @return 归属部门
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * 归属部门
	 * @param officeId 归属部门
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/**
	 * 登录名
	 * @return 登录名
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 登录名
	 * @param loginName 登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 密码
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 工号
	 * @return 工号
	 */
	public String getNo() {
		return no;
	}

	/**
	 * 工号
	 * @param no 工号
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * 姓名
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 邮箱
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 电话
	 * @return 电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 电话
	 * @param phone 电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 手机
	 * @return 手机
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机
	 * @param mobile 手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 用户类型
	 * @return 用户类型
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型
	 * @param userType 用户类型
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 用户头像
	 * @return 用户头像
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 用户头像
	 * @param photo 用户头像
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 最后登陆IP
	 * @return 最后登陆IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 最后登陆IP
	 * @param loginIp 最后登陆IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * 最后登陆时间
	 * @return 最后登陆时间
	 */
	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * 最后登陆时间
	 * @param loginDate 最后登陆时间
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * 是否可登录
	 * @return 是否可登录
	 */
	public String getLoginFlag() {
		return loginFlag;
	}

	/**
	 * 是否可登录
	 * @param loginFlag 是否可登录
	 */
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	/**
	 * 创建者
	 * @return 创建者
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 创建者
	 * @param createBy 创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 创建时间
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间
	 * @param createDate 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新者
	 * @return 更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 更新者
	 * @param updateBy 更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 更新时间
	 * @return 更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新时间
	 * @param updateDate 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 备注信息
	 * @return 备注信息
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注信息
	 * @param remarks 备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 删除标记
	 * @return 删除标记
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * 删除标记
	 * @param delFlag 删除标记
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 二维码
	 * @return 二维码
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * 二维码
	 * @param qrcode 二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	/**
	 * 个性签名
	 * @return 个性签名
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 个性签名
	 * @param sign 个性签名
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
}
	
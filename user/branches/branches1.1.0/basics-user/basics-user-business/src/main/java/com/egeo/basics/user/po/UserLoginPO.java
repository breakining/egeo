package com.egeo.basics.user.po;


import java.util.Date;

/**
 * 
 * @author xiaping
 * @date 2017-05-11 11:13:57
 */
public class UserLoginPO {


	private Integer id;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 登陆结果
	 */
	private Integer loginResult;

	/**
	 * 登陆时间
	 */
	private Date loginTime;

	/**
	 * ip
	 */
	private String ip;

	/**
	 * 浏览器信息
	 */
	private String browser;

	/**
	 * 是否可用:默认0否;1是
	 */
	private Integer isAvailable;

	/**
	 * 是否逻辑删除:默认0未删除;1已删除
	 */
	private Integer isDeleted;

	/**
	 * 版本号:默认0,每次更新+1
	 */
	private Integer versionNo;

	/**
	 * 创建人ID
	 */
	private String createUserid;

	/**
	 * 创建人姓名
	 */
	private String createUsername;

	/**
	 * 创建人IP
	 */
	private String createUserip;

	/**
	 * 创建人MAC地址
	 */
	private String createUsermac;

	/**
	 * 创建时间-应用操作时间
	 */
	private Date createTime;

	/**
	 * 创建时间-数据库操作时间
	 */
	private Date createTimeDb;

	/**
	 * 服务器IP
	 */
	private String serverIp;

	/**
	 * 最后修改人ID
	 */
	private Long updateUserid;

	/**
	 * 最后修改人姓名
	 */
	private String updateUsername;

	/**
	 * 最后修改人IP
	 */
	private String updateUserip;

	/**
	 * 最后修改人MAC
	 */
	private String updateUsermac;

	/**
	 * 最后修改时间
	 */
	private Date updateTime;

	/**
	 * 最后修改时间-数据库默认写入时间
	 */
	private Date updateTimeDb;

	/**
	 * 客户端程序的版本号
	 */
	private String clientVersionno;

	/**
	 * 公司id
	 */
	private String companyId;

	/**
	 * 平台id
	 */
	private String platformId;

	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 用户id
	 * @return 用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 * @param userId 用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 登陆结果
	 * @return 登陆结果
	 */
	public Integer getLoginResult() {
		return loginResult;
	}

	/**
	 * 登陆结果
	 * @param loginResult 登陆结果
	 */
	public void setLoginResult(Integer loginResult) {
		this.loginResult = loginResult;
	}

	/**
	 * 登陆时间
	 * @return 登陆时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 登陆时间
	 * @param loginTime 登陆时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * ip
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip
	 * @param ip ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 浏览器信息
	 * @return 浏览器信息
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * 浏览器信息
	 * @param browser 浏览器信息
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * 是否可用:默认0否;1是
	 * @return 是否可用:默认0否;1是
	 */
	public Integer getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 是否可用:默认0否;1是
	 * @param isAvailable 是否可用:默认0否;1是
	 */
	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * 是否逻辑删除:默认0未删除;1已删除
	 * @return 是否逻辑删除:默认0未删除;1已删除
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 是否逻辑删除:默认0未删除;1已删除
	 * @param isDeleted 是否逻辑删除:默认0未删除;1已删除
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 版本号:默认0,每次更新+1
	 * @return 版本号:默认0,每次更新+1
	 */
	public Integer getVersionNo() {
		return versionNo;
	}

	/**
	 * 版本号:默认0,每次更新+1
	 * @param versionNo 版本号:默认0,每次更新+1
	 */
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	/**
	 * 创建人ID
	 * @return 创建人ID
	 */
	public String getCreateUserid() {
		return createUserid;
	}

	/**
	 * 创建人ID
	 * @param createUserid 创建人ID
	 */
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	/**
	 * 创建人姓名
	 * @return 创建人姓名
	 */
	public String getCreateUsername() {
		return createUsername;
	}

	/**
	 * 创建人姓名
	 * @param createUsername 创建人姓名
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	/**
	 * 创建人IP
	 * @return 创建人IP
	 */
	public String getCreateUserip() {
		return createUserip;
	}

	/**
	 * 创建人IP
	 * @param createUserip 创建人IP
	 */
	public void setCreateUserip(String createUserip) {
		this.createUserip = createUserip;
	}

	/**
	 * 创建人MAC地址
	 * @return 创建人MAC地址
	 */
	public String getCreateUsermac() {
		return createUsermac;
	}

	/**
	 * 创建人MAC地址
	 * @param createUsermac 创建人MAC地址
	 */
	public void setCreateUsermac(String createUsermac) {
		this.createUsermac = createUsermac;
	}

	/**
	 * 创建时间-应用操作时间
	 * @return 创建时间-应用操作时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间-应用操作时间
	 * @param createTime 创建时间-应用操作时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建时间-数据库操作时间
	 * @return 创建时间-数据库操作时间
	 */
	public Date getCreateTimeDb() {
		return createTimeDb;
	}

	/**
	 * 创建时间-数据库操作时间
	 * @param createTimeDb 创建时间-数据库操作时间
	 */
	public void setCreateTimeDb(Date createTimeDb) {
		this.createTimeDb = createTimeDb;
	}

	/**
	 * 服务器IP
	 * @return 服务器IP
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * 服务器IP
	 * @param serverIp 服务器IP
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	/**
	 * 最后修改人ID
	 * @return 最后修改人ID
	 */
	public Long getUpdateUserid() {
		return updateUserid;
	}

	/**
	 * 最后修改人ID
	 * @param updateUserid 最后修改人ID
	 */
	public void setUpdateUserid(Long updateUserid) {
		this.updateUserid = updateUserid;
	}

	/**
	 * 最后修改人姓名
	 * @return 最后修改人姓名
	 */
	public String getUpdateUsername() {
		return updateUsername;
	}

	/**
	 * 最后修改人姓名
	 * @param updateUsername 最后修改人姓名
	 */
	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

	/**
	 * 最后修改人IP
	 * @return 最后修改人IP
	 */
	public String getUpdateUserip() {
		return updateUserip;
	}

	/**
	 * 最后修改人IP
	 * @param updateUserip 最后修改人IP
	 */
	public void setUpdateUserip(String updateUserip) {
		this.updateUserip = updateUserip;
	}

	/**
	 * 最后修改人MAC
	 * @return 最后修改人MAC
	 */
	public String getUpdateUsermac() {
		return updateUsermac;
	}

	/**
	 * 最后修改人MAC
	 * @param updateUsermac 最后修改人MAC
	 */
	public void setUpdateUsermac(String updateUsermac) {
		this.updateUsermac = updateUsermac;
	}

	/**
	 * 最后修改时间
	 * @return 最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 最后修改时间
	 * @param updateTime 最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 最后修改时间-数据库默认写入时间
	 * @return 最后修改时间-数据库默认写入时间
	 */
	public Date getUpdateTimeDb() {
		return updateTimeDb;
	}

	/**
	 * 最后修改时间-数据库默认写入时间
	 * @param updateTimeDb 最后修改时间-数据库默认写入时间
	 */
	public void setUpdateTimeDb(Date updateTimeDb) {
		this.updateTimeDb = updateTimeDb;
	}

	/**
	 * 客户端程序的版本号
	 * @return 客户端程序的版本号
	 */
	public String getClientVersionno() {
		return clientVersionno;
	}

	/**
	 * 客户端程序的版本号
	 * @param clientVersionno 客户端程序的版本号
	 */
	public void setClientVersionno(String clientVersionno) {
		this.clientVersionno = clientVersionno;
	}

	/**
	 * 公司id
	 * @return 公司id
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * 公司id
	 * @param companyId 公司id
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 平台id
	 * @return 平台id
	 */
	public String getPlatformId() {
		return platformId;
	}

	/**
	 * 平台id
	 * @param platformId 平台id
	 */
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
}
	
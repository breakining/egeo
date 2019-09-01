package com.egeo.basics.user.po;

import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:15
 */
public class UserPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱地址
     */
    private String mail;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 
     */
    private String token;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 最新一次更新盐的时间
     */
    private Date updateSalt;

    /**
     * 用户所在公司的id
     */
    private Long companyId;

    // 创建开始时间
    private Data beginTime;

    // 创建结束时间
    private Data finishTime;


    public Long getId() {
        return id;
    }

    /**
     * 编号
     * 
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 登录名
     * 
     * @return 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     * 
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 手机
     * 
     * @return 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机
     * 
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 邮箱地址
     * 
     * @return 邮箱地址
     */
    public String getMail() {
        return mail;
    }

    /**
     * 邮箱地址
     * 
     * @param mail 邮箱地址
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 删除标记
     * 
     * @return 删除标记
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记
     * 
     * @param delFlag 删除标记
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 二维码
     * 
     * @return 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 二维码
     * 
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 加密盐
     * 
     * @return 加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 加密盐
     * 
     * @param salt 加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 最新一次更新盐的时间
     * 
     * @return 最新一次更新盐的时间
     */
    public Date getUpdateSalt() {
        return updateSalt;
    }

    /**
     * 最新一次更新盐的时间
     * 
     * @param updateSalt 最新一次更新盐的时间
     */
    public void setUpdateSalt(Date updateSalt) {
        this.updateSalt = updateSalt;
    }

    /**
     * 用户所在公司的id
     * 
     * @return 用户所在公司的id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 用户所在公司的id
     * 
     * @param companyId 用户所在公司的id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Data getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Data beginTime) {
        this.beginTime = beginTime;
    }

    public Data getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Data finishTime) {
        this.finishTime = finishTime;
    }

}

package com.egeo.basics.user.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:14
 */
public class MenuPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 父级编号
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private BigDecimal sort;

    /**
     * 链接
     */
    private String href;

    /**
     * 目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否在菜单中显示
     */
    private String isShow;

    /**
     * 权限标识
     */
    private String permission;

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

    private List<Long> pid;

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
     * 父级编号
     * 
     * @return 父级编号
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级编号
     * 
     * @param parentId 父级编号
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 名称
     * 
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * 
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 排序
     * 
     * @return 排序
     */
    public BigDecimal getSort() {
        return sort;
    }

    /**
     * 排序
     * 
     * @param sort 排序
     */
    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    /**
     * 链接
     * 
     * @return 链接
     */
    public String getHref() {
        return href;
    }

    /**
     * 链接
     * 
     * @param href 链接
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 目标
     * 
     * @return 目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 目标
     * 
     * @param target 目标
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 图标
     * 
     * @return 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * 
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 是否在菜单中显示
     * 
     * @return 是否在菜单中显示
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 是否在菜单中显示
     * 
     * @param isShow 是否在菜单中显示
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 权限标识
     * 
     * @return 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 权限标识
     * 
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 创建者
     * 
     * @return 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * 
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * 
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新者
     * 
     * @return 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * 
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     * 
     * @return 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * 
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 备注信息
     * 
     * @return 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * 
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 删除标记
     * 
     * @return 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记
     * 
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<Long> getPid() {
        return pid;
    }

    public void setPid(List<Long> pid) {
        this.pid = pid;
    }
    
    

}

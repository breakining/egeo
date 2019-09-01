package com.egeo.basics.user.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:45:25
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String title;

    /**
     * 父级编号
     */
    private Long parentId;

    private String index;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否在菜单中显示
     */
    private String isShow;

    /**
     * 排序
     */
    private BigDecimal sort;

    private List<Menu> children;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

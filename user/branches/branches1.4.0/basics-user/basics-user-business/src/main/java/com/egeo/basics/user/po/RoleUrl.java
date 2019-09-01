package com.egeo.basics.user.po;

import java.io.Serializable;

public class RoleUrl implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long roleId;
    private String urls;
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getUrls() {
        return urls;
    }
    public void setUrls(String urls) {
        this.urls = urls;
    }
    
    
}

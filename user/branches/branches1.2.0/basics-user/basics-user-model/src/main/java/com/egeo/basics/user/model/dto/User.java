package com.egeo.basics.user.model.dto;

import java.io.Serializable;

public class User implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cookieValue;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCookieValue() {
        return cookieValue;
    }
    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }
    

}

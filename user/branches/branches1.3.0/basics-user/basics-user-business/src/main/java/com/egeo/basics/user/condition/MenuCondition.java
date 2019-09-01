package com.egeo.basics.user.condition;

import com.egeo.basics.user.po.MenuPO;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:45:25
 */
public class MenuCondition extends MenuPO {
	private static final long serialVersionUID = 1L;
	
	
	private String parentName;


    public String getParentName() {
        return parentName;
    }


    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
	
	
}
	
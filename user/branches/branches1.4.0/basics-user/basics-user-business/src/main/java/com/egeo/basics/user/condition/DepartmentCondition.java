package com.egeo.basics.user.condition;

import com.egeo.basics.user.po.DepartmentPO;

/**
 * 
 * @author min
 * @date 2017-11-17 18:10:53
 */
public class DepartmentCondition extends DepartmentPO {
	private static final long serialVersionUID = 1L;
	/**
	 * 部门父id
	 */
	private Long pId;
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	
}
	
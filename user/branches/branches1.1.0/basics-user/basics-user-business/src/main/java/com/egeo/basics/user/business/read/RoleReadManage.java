package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.RolePO;

public interface RoleReadManage {
	
	List<RolePO> findRoleListByUserId(String id);
}
	
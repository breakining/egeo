package com.egeo.basics.user.business.read;

import java.util.List;
import com.egeo.basics.user.po.RoleMenuPO;

public interface RoleMenuReadManage {

	public List<RoleMenuPO> findAll(RoleMenuPO roleMenuPO);
	
}
	
package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.SysRolePO;

public interface SysRoleReadManage {
	
	public  List<SysRolePO> findAll(SysRolePO sysRolePO);

}
	
package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.SysUserPO;

public interface SysUserReadManage {
	
	public  List<SysUserPO> findAll(SysUserPO sysUserPO);
}
	
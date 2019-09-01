package com.egeo.basics.user.business.write;


import com.egeo.basics.user.po.SysRolePO;

public interface SysRoleWriteManage {
	
	 //新增
	  public int insert(SysRolePO sysRolePO);
	  
	  //删除
	  public int delete(Integer id);
	  
	  //修改
	  public int update(SysRolePO sysRolePO);
}
	
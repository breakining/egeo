package com.egeo.basics.user.business.read;

import java.util.List;
import com.egeo.basics.user.po.PlatformRolePO;

public interface PlatformRoleReadManage {

	public List<PlatformRolePO> findAll(PlatformRolePO platformRolePO);
	
}
	
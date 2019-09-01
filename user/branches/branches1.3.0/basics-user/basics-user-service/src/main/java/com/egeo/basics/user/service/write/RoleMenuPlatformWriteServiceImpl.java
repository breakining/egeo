package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.RoleMenuPlatformWriteService;
import com.egeo.basics.user.business.write.RoleMenuPlatformWriteManage;

@Service("roleMenuPlatformWriteService")
public class RoleMenuPlatformWriteServiceImpl extends BaseService implements RoleMenuPlatformWriteService {
	@Autowired
	private RoleMenuPlatformWriteManage roleMenuPlatformWriteManage;
}
	
package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.PlatformRoleWriteService;
import com.egeo.basics.user.business.write.PlatformRoleWriteManage;
import com.egeo.core.basics.service.BaseService;

@Service("platformRoleWriteService")
public class PlatformRoleWriteServiceImpl extends BaseService implements PlatformRoleWriteService {
	@Autowired
	private PlatformRoleWriteManage platformRoleWriteManage;
}
	
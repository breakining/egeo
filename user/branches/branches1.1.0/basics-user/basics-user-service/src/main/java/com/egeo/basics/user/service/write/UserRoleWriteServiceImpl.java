package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.UserRoleWriteService;
import com.egeo.basics.user.business.write.UserRoleWriteManage;

@Service("userRoleWriteService")
public class UserRoleWriteServiceImpl extends BaseService implements UserRoleWriteService {
	@Autowired
	private UserRoleWriteManage userRoleWriteManage;
}
	
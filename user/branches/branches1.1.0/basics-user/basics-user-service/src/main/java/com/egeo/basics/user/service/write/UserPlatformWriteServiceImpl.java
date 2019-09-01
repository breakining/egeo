package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.UserPlatformWriteService;
import com.egeo.basics.user.business.write.UserPlatformWriteManage;

@Service("userPlatformWriteService")
public class UserPlatformWriteServiceImpl extends BaseService implements UserPlatformWriteService {
	@Autowired
	private UserPlatformWriteManage userPlatformWriteManage;
}
	
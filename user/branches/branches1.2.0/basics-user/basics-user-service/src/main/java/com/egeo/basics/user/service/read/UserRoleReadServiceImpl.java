package com.egeo.basics.user.service.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.UserRoleReadService;
import com.egeo.basics.user.business.read.UserRoleReadManage;

@Service("userRoleReadService")
public class UserRoleReadServiceImpl extends BaseService implements UserRoleReadService {
	@Autowired
	private UserRoleReadManage userRoleReadManage;
}
	
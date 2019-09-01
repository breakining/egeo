package com.egeo.basics.user.service.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.UserLoginReadService;
import com.egeo.basics.user.business.read.UserLoginReadManage;

@Service("userLoginReadService")
public class UserLoginReadServiceImpl extends BaseService implements UserLoginReadService {
	@Autowired
	private UserLoginReadManage userLoginReadManage;
}
	
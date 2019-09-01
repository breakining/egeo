package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UserRoleReadService;


@Component
public class UserRoleFacade {
	
	@Reference
	private UserRoleReadService userRoleReadService;
	


}
	
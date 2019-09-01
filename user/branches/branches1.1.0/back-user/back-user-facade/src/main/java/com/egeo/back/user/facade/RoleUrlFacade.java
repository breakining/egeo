package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.RoleUrlReadService;


@Component
public class RoleUrlFacade {
	
	@Reference
	private RoleUrlReadService roleUrlReadService;

	public List<String> getUrlListByUserId(String userId) {
		// TODO Auto-generated method stub
		return roleUrlReadService.getUrlListByUserId(userId);
	}
	


}
	
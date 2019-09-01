package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.RoleMenuPlatformReadService;


@Component
public class RoleMenuPlatformFacade {
	
	@Reference
	private RoleMenuPlatformReadService roleMenuPlatformReadService;

	public List<String> getMenuList(Long userId, Long platformId) {
		// TODO Auto-generated method stub
		return roleMenuPlatformReadService.getMenuList(userId,platformId);
	}
	


}
	
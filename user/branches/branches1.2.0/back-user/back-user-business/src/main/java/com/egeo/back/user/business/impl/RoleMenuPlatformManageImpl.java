package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.RoleMenuPlatformManage;
import com.egeo.back.user.facade.RoleMenuPlatformFacade;

@Service("roleMenuPlatform")
public class RoleMenuPlatformManageImpl implements RoleMenuPlatformManage{

	
	@Resource(name="roleMenuPlatformFacade")
	private RoleMenuPlatformFacade roleMenuPlatformFacade;

	@Override
	public List<String> getMenuList(Long userId, Long platformId) {
		// TODO Auto-generated method stub
		return roleMenuPlatformFacade.getMenuList(userId,platformId);
	}
	


}
	
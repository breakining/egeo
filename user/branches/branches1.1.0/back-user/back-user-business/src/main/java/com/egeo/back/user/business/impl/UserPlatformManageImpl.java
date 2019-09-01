package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserPlatformManage;
import com.egeo.back.user.facade.UserPlatformFacade;
import com.egeo.basics.user.model.dto.UserPlatformDTO;

@Service("userPlatform")
public class UserPlatformManageImpl implements UserPlatformManage{

	
	@Resource(name="userPlatformFacade")
	private UserPlatformFacade userPlatformFacade;

	@Override
	public boolean userIsExitPlatform(UserPlatformDTO userPlatformDTO) {
		// TODO Auto-generated method stub
		return userPlatformFacade.userIsExitPlatform(userPlatformDTO);
	}
	


}
	
package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UserCookieReadService;
import com.egeo.basics.user.api.write.UserCookieWriteService;
import com.egeo.basics.user.model.dto.UserCookieDTO;


@Component
public class UserCookieFacade {
	
	@Reference
	private UserCookieWriteService userCookieWriteService;
	
	@Reference
	private UserCookieReadService userCookieReadService;

	public void saveUserCookieWithTx(UserCookieDTO userCookieDTO) {
		// TODO Auto-generated method stub
		userCookieWriteService.saveUserCookieWithTx(userCookieDTO);
		
	}

	public UserCookieDTO getbyUserId(Long userId) {
		// TODO Auto-generated method stub
		return userCookieReadService.getbyUserId(userId);
	}
	


}
	
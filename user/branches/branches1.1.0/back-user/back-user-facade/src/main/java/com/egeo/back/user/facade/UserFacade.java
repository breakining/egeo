package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UserReadService;
import com.egeo.basics.user.api.write.UserWriteService;
import com.egeo.basics.user.model.dto.UserDTO;


@Component
public class UserFacade {
	
	@Reference
	private UserReadService userReadService;
	
	@Reference
	private UserWriteService userWriteService;
	

	public UserDTO findUniqueUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return userReadService.findUniqueUser(dto);
	}

	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		// TODO Auto-generated method stub
		return userWriteService.updateEncryptInfoByUserWithTx(updUser);
	}

	public UserDTO findUserByID(String userId) {
		// TODO Auto-generated method stub
		return userReadService.findUserByID(userId);
	}

}
	
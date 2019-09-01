package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.write.UserLoginWriteService;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserLoginDTO;


@Component
public class UserLoginFacade {
	
	@Reference
	private UserLoginWriteService userLoginWriteService;

	public void insertLoginLogWithTx(UserLoginDTO userLogin) {
		// TODO Auto-generated method stub
		userLoginWriteService.insertLoginLogWithTx(userLogin);
	}




}
	
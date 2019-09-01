package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.UserLoginWriteService;
import com.egeo.basics.user.business.write.UserLoginWriteManage;
import com.egeo.basics.user.converter.UserLoginConverter;
import com.egeo.basics.user.model.dto.UserLoginDTO;
import com.egeo.core.basics.service.BaseService;

@Service("userLoginWriteService")
public class UserLoginWriteServiceImpl extends BaseService implements UserLoginWriteService {
	@Autowired
	private UserLoginWriteManage userLoginWriteManage;

	@Override
	public void insertLoginLogWithTx(UserLoginDTO userLogin) {
		
		userLoginWriteManage.insertLoginLogWithTx(UserLoginConverter.toPO(userLogin));
	}

	
	
}
	
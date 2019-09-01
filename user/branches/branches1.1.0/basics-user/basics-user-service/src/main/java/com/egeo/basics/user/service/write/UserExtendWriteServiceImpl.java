package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.UserExtendWriteService;
import com.egeo.basics.user.business.write.UserExtendWriteManage;

@Service("userExtendWriteService")
public class UserExtendWriteServiceImpl extends BaseService implements UserExtendWriteService {
	@Autowired
	private UserExtendWriteManage userExtendWriteManage;
}
	
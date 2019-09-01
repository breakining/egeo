package com.egeo.basics.user.service.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.UserCookieReadService;
import com.egeo.basics.user.business.read.UserCookieReadManage;
import com.egeo.basics.user.model.dto.UserCookieDTO;

@Service("userCookieReadService")
public class UserCookieReadServiceImpl extends BaseService implements UserCookieReadService {
	@Autowired
	private UserCookieReadManage userCookieReadManage;

	

}
	
package com.egeo.basics.user.business.read;

import com.egeo.basics.user.po.UserCookiePO;

public interface UserCookieReadManage {

	UserCookiePO getbyUserId(Long userId);
}
	
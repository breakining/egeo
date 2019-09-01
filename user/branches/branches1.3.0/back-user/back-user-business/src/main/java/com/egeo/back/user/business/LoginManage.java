package com.egeo.back.user.business;

import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.web.JsonResult;

public interface LoginManage {

	JsonResult<CacheUser> login(UserVO user);

	void saveUttoCache(UserVO user, UserCookieVO userCookie);

}

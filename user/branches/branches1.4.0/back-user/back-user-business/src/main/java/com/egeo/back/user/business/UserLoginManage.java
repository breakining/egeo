package com.egeo.back.user.business;

import javax.servlet.http.HttpServletRequest;

import com.egeo.back.user.model.vo.UserVO;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.web.JsonResult;

public interface UserLoginManage {

	void insertLoginLogWithTx(JsonResult<CacheUser> rt, HttpServletRequest req);

	void insertLoginExceptionLogWithTx(int code, UserVO user, HttpServletRequest req);
	

	

}
	
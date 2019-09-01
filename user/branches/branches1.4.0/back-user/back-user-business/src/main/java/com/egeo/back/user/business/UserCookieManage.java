package com.egeo.back.user.business;

import javax.servlet.http.HttpServletRequest;

import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.basics.user.model.dto.UserCookieDTO;

public interface UserCookieManage {

	void saveUserCookieWithTx(UserCookieVO userCookie, HttpServletRequest req);

	UserCookieDTO getbyUserId(Long id);

	void deleteCookieUserbyUserId(Long id);
	

}
	
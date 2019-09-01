package com.egeo.basics.user.api.read;

import com.egeo.basics.user.model.dto.UserCookieDTO;

public interface UserCookieReadService {

	UserCookieDTO getbyUserId(Long userId);


}
	
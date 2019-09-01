package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserCookieDTO;


public interface UserCookieWriteService {

    void saveUserCookieWithTx(UserCookieDTO userCookieDTO);

    int updateWithTx(UserCookieDTO userCookieDTO);

	void deleteCookieUserbyUserIdWithTx(Long userId);

}

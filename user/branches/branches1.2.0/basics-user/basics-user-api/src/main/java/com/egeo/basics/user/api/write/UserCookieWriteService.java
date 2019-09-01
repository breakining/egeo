package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.po.UserCookiePO;

public interface UserCookieWriteService {

    void saveUserCookieWithTx(UserCookieDTO userCookieDTO);

    int update(UserCookieDTO userCookieDTO);

}

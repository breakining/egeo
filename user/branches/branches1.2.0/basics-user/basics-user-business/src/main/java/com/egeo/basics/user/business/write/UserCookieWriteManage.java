package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserCookiePO;

public interface UserCookieWriteManage {

    void saveUserCookieWithTx(UserCookiePO po);

    int update(UserCookiePO po);

    UserCookiePO getbyUserId(Long id);
}

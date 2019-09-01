package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.basics.user.po.UserPO;

public interface UserWriteManage {

    int updateEncryptInfoByUserWithTx(UserPO po);

    int updateUserInfo(UserPO po);

    String saveOrUpdateWithTx(UserPO po, UserExtendPO userExtendPO, UserCookiePO userCookiePO);

    void delete(Long id);

    UserPO getIdUser(UserPO po);

    Long save(UserPO po);

    int update(UserPO tar);

}

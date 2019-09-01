package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.UserPlatformPO;

public interface UserPlatformReadManage {

    boolean userIsExitPlatform(UserPlatformPO po);

    UserPlatformPO findById(UserPlatformPO po);

    List<UserPlatformPO> findAll(UserPlatformPO po);
}

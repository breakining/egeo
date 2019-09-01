package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserPlatformPO;

public interface UserPlatformWriteManage {

    String save(UserPlatformPO po);

    String update(UserPlatformPO po);

    String deleteByUserIdAndPid(UserPlatformPO po);

    int delUserPlatform(UserPlatformPO platformPO);
}
	
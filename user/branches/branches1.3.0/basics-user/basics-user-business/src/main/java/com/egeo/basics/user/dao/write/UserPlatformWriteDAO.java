package com.egeo.basics.user.dao.write;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.UserPlatformPO;
import com.egeo.core.orm.BaseWriteDAO;

public interface UserPlatformWriteDAO extends BaseWriteDAO<UserPlatformPO> {

    int deleteByUserIdAndPid(UserPlatformPO po);

    int delUserPlatform(@Param("po") UserPlatformPO platformPO);
}
	
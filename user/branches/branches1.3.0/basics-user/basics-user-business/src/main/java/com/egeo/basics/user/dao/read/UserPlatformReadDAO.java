package com.egeo.basics.user.dao.read;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.UserPlatformPO;
import com.egeo.core.orm.BaseReadDAO;

public interface UserPlatformReadDAO extends BaseReadDAO<UserPlatformPO> {

    UserPlatformPO userIsExitPlatform(@Param("po") UserPlatformPO po);
}

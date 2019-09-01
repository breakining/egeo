package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.PlatformPO;

public interface PlatformReadManage {

    List<PlatformPO> findAll(PlatformPO po);

    PlatformPO findRoleByRoleName(String name);

    List<PlatformPO> PlatformByUserId(String useId);
}
	
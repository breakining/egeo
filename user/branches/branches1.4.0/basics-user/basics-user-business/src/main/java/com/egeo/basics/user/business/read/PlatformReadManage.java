package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.PlatformPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface PlatformReadManage {

    List<PlatformPO> findAll(PlatformPO po);

    PlatformPO findRoleByRoleName(String name);

    List<PlatformPO> PlatformByUserId(Long useId);

    PlatformPO find(Long pid);

    List<PlatformPO> PlatformByUid(Long userId);

    PlatformPO findById(PlatformPO po);

    PageResult<PlatformPO> findPage(Pagination page, PlatformPO po);
}
	
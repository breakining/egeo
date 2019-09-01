package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.RolePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface RoleReadManage {

    List<RolePO> findRoleListByUserId(Long id);

    RolePO findRoleByRoleName(String name);

    List<RolePO> findAll(RolePO dto);

    List<RolePO> roleByPlatformId(Long platformId);

    List<RolePO> roleListByUserId(Long id);

    PageResult<RolePO> findPageUser(Pagination page, RolePO po);

    RolePO findById(RolePO po);
}

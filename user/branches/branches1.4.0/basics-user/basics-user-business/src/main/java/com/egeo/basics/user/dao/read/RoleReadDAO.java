package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.RolePO;
import com.egeo.core.orm.BaseReadDAO;

public interface RoleReadDAO extends BaseReadDAO<RolePO> {

    List<RolePO> findRoleListByUserId(@Param("po") RolePO po);

    List<RolePO> roleByPlatformId(Long platformId);

    List<RolePO> roleListByUserId(Long id);
}

package com.egeo.basics.user.business.write;

import java.util.List;

import com.egeo.basics.user.po.RolePO;

public interface RoleWriteManage {

    Long saveRoleWithTx(RolePO po);

    int removeRoleWithTx(String name);

    int updateRoleWithTx(RolePO po);

    int upDate(RolePO po);

    int delMenu(StringBuffer delUrl, Long roleId);

    int setMenu(List<String> setMenu, Long roleId);

    int deleteByIdWithTx(RolePO po);

}

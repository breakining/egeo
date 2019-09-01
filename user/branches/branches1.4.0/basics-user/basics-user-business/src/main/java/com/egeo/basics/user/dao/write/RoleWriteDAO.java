package com.egeo.basics.user.dao.write;

import com.egeo.basics.user.po.RolePO;
import com.egeo.basics.user.po.RoleUrl;
import com.egeo.core.orm.BaseWriteDAO;

public interface RoleWriteDAO extends BaseWriteDAO<RolePO> {

    int delUrl(String delUrl, String roleId);

    int delMenu(RoleUrl roleUrl);
}
	
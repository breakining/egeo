package com.egeo.basics.user.dao.write;

import com.egeo.basics.user.po.RoleUrl;
import com.egeo.basics.user.po.RoleUrlPO;
import com.egeo.core.orm.BaseWriteDAO;

public interface RoleUrlWriteDAO extends BaseWriteDAO<RoleUrlPO> {

    int delUrl(RoleUrl roleUrl);
}
	
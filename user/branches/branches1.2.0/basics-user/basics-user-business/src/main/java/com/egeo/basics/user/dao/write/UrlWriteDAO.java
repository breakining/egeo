package com.egeo.basics.user.dao.write;

import java.util.List;

import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.orm.BaseWriteDAO;

public interface UrlWriteDAO extends BaseWriteDAO<UrlPO> {

	UrlPO findById(UrlPO po);

    List<UrlPO> getUrlByRoleId(String roleId);

}
	
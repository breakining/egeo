package com.egeo.basics.user.dao.read;

import java.util.List;

import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.orm.BaseReadDAO;

public interface UrlReadDAO extends BaseReadDAO<UrlPO>{

	List<String> getUrlListByUserId(Long userId);

    List<UrlPO> getUrlByRoleId(Long roleId);
}
	
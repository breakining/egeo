package com.egeo.basics.user.business.read;

import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserExtendReadManage {

	UserExtendPO findById(Long id);
	public PageResult<UserExtendPO> findPage(Pagination page,UserExtendPO po);
}
	
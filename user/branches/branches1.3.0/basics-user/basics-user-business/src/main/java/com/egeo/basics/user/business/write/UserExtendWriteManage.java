package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserExtendPO;

public interface UserExtendWriteManage {

    int save(UserExtendPO userExtendPO);

    int update(UserExtendPO userExtendPO);

	int deleteWithTx(UserExtendPO po);
}
	
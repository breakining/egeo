package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserPO;

public interface UserWriteManage {

	int updateEncryptInfoByUserWithTx(UserPO po);
}
	
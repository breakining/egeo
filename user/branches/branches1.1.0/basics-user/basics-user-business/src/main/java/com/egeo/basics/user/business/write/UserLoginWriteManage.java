package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserLoginPO;

public interface UserLoginWriteManage {

	void insertLoginLogWithTx(UserLoginPO po);	
}
	
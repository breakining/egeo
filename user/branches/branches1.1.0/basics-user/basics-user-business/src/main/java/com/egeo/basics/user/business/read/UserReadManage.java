package com.egeo.basics.user.business.read;

import com.egeo.basics.user.po.UserPO;

public interface UserReadManage {

	UserPO findUniqueUser(UserPO po);

	UserPO findUserByID(String userId);
}
	
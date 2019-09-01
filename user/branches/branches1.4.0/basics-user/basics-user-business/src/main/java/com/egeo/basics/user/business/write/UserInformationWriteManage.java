package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserInformationPO;


public interface UserInformationWriteManage {

	Long insertUserInformationWithTx(UserInformationPO po);

	int updateUserInformationWithTx(UserInformationPO po);

	int deleteUserInformationWithTx(UserInformationPO po);
}
	
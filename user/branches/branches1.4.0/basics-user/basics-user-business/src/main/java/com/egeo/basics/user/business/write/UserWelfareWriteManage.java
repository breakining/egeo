package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserWelfarePO;


public interface UserWelfareWriteManage {

	Long insertUserWelfareWithTx(UserWelfarePO po);

	int updateUserWelfareWithTx(UserWelfarePO po);

	int deleteUserWelfareWithTx(UserWelfarePO po);
	/**
	 * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
	 * @param dto
	 * @return
	 */
	int updateUserWelfareByUserIdWithTx(UserWelfarePO po);
}
	
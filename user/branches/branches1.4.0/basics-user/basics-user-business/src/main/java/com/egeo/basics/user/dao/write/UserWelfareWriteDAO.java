package com.egeo.basics.user.dao.write;

import com.egeo.basics.user.po.UserWelfarePO;
import com.egeo.core.orm.BaseWriteDAO;

public interface UserWelfareWriteDAO extends BaseWriteDAO<UserWelfarePO> {
	/**
	 * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
	 * @param dto
	 * @return
	 */
	int updateUserWelfareByUserIdWithTx(UserWelfarePO po);
}
	
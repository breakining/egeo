package com.egeo.basics.user.dao.read;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.UserInformationPO;
import com.egeo.core.orm.BaseReadDAO;

public interface UserInformationReadDAO extends BaseReadDAO<UserInformationPO>{
	/**
	 * 根据userId查询未读用户消息数量
	 * @param vo
	 * @param req
	 * @return
	 */
	int cntByUserId(@Param("po")UserInformationPO po);
}
	
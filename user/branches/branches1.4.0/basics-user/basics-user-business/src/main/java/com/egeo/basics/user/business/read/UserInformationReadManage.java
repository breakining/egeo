package com.egeo.basics.user.business.read;

import java.util.List;
	
import com.egeo.basics.user.po.UserInformationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface UserInformationReadManage {

	public UserInformationPO findUserInformationById(UserInformationPO po);

	public PageResult<UserInformationPO> findUserInformationOfPage(UserInformationPO po,Pagination page);

	public List<UserInformationPO> findUserInformationAll(UserInformationPO po);
	/**
	 * 根据userId查询未读用户消息数量
	 * @param vo
	 * @param req
	 * @return
	 */
	public int cntByUserId(UserInformationPO po);
}
	
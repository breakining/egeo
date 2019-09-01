package com.egeo.basics.user.business.read;

import java.util.List;
	
import com.egeo.basics.user.po.UserWelfarePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface UserWelfareReadManage {

	public UserWelfarePO findUserWelfareById(UserWelfarePO po);

	public PageResult<UserWelfarePO> findUserWelfareOfPage(UserWelfarePO po,Pagination page);

	public List<UserWelfarePO> findUserWelfareAll(UserWelfarePO po);

	/**
	 * 批量查询uw
	 * @param userIdList
	 * @return
	 */
	public List<UserWelfarePO> queryUserWelfaresByUserIds(List<Long> userIdList);
}
	
package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserInformationReadManage;
import com.egeo.basics.user.dao.read.UserInformationReadDAO;
import com.egeo.basics.user.po.UserInformationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class UserInformationReadManageImpl implements UserInformationReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserInformationReadDAO userInformationReadDAO;
	
	public UserInformationPO findUserInformationById(UserInformationPO po) {
		UserInformationPO userInformationpo = new UserInformationPO();
		userInformationpo.setId(po.getId());
		return userInformationReadDAO.findById(userInformationpo);
	}

	public PageResult<UserInformationPO> findUserInformationOfPage(UserInformationPO po, Pagination page) {
		
		PageResult<UserInformationPO> pageResult = new PageResult<UserInformationPO>();
		List<UserInformationPO> list = null;

		int cnt = userInformationReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = userInformationReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<UserInformationPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<UserInformationPO> findUserInformationAll(UserInformationPO po) {

		return userInformationReadDAO.findAll(po);
	}
	/**
	 * 根据userId查询未读用户消息数量
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public int cntByUserId(UserInformationPO po) {
		
		return userInformationReadDAO.cntByUserId(po);
	}
	
}
	
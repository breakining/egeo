package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserExtendReadManage;
import com.egeo.basics.user.dao.read.UserExtendReadDAO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service
public class UserExtendReadManageImpl implements UserExtendReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserExtendReadDAO userExtendReadDAO;
	@Override
	public UserExtendPO findById(Long id) {
		// TODO Auto-generated method stub
		UserExtendPO po = new UserExtendPO();
		po.setId(id);
		return userExtendReadDAO.findById(po);
	}
    @Override
    public PageResult<UserExtendPO> findPage(Pagination page, UserExtendPO po) {
        int cnt = userExtendReadDAO.countOfPage(po);
        List<UserExtendPO> list = new ArrayList<UserExtendPO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
                page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
                list = userExtendReadDAO.findOfPage(po, page);
        }
        PageResult<UserExtendPO> pageResult = new PageResult<UserExtendPO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
    }
	
}
	
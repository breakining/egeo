package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.CompanyReadManage;
import com.egeo.basics.user.dao.read.CompanyReadDAO;
import com.egeo.basics.user.po.CompanyPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service
public class CompanyReadManageImpl implements CompanyReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CompanyReadDAO companyReadDAO;
	
	@Override
	public PageResult<CompanyPO> findPage(Pagination page, CompanyPO po) {
		int cnt = companyReadDAO.countOfPage(po);
        List<CompanyPO> list = new ArrayList<CompanyPO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = companyReadDAO.findOfPage(po, page);
        }
        PageResult<CompanyPO> pageResult = new PageResult<CompanyPO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
	}

	@Override
	public List<CompanyPO> findAll(CompanyPO companyPO) {
		List<CompanyPO> list = companyReadDAO.findAll(companyPO);
        if(list.size() > 0){
            return list;
        }
        return null;
	}

	@Override
	public List<CompanyPO> companyByUserId(Long userId) {
		// TODO Auto-generated method stub
		return companyReadDAO.companyByUserId(userId);
	}

	@Override
	public List<CompanyPO> companyByUId(Long userId) {
		// TODO Auto-generated method stub
		return companyReadDAO.companyByUid(userId);
	}
	
}
	
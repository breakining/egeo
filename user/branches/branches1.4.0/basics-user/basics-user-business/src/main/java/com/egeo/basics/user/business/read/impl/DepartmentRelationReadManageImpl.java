package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.DepartmentRelationReadManage;
import com.egeo.basics.user.dao.read.DepartmentRelationReadDAO;
import com.egeo.basics.user.po.DepartmentRelationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class DepartmentRelationReadManageImpl implements DepartmentRelationReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DepartmentRelationReadDAO departmentRelationReadDAO;
	
	public DepartmentRelationPO findDepartmentRelationById(DepartmentRelationPO po) {
		DepartmentRelationPO departmentRelationpo = new DepartmentRelationPO();
		departmentRelationpo.setId(po.getId());
		return departmentRelationReadDAO.findById(departmentRelationpo);
	}

	public PageResult<DepartmentRelationPO> findDepartmentRelationOfPage(DepartmentRelationPO po, Pagination page) {
		
		PageResult<DepartmentRelationPO> pageResult = new PageResult<DepartmentRelationPO>();
		List<DepartmentRelationPO> list = null;

		int cnt = departmentRelationReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = departmentRelationReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<DepartmentRelationPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<DepartmentRelationPO> findDepartmentRelationAll(DepartmentRelationPO po) {

		return departmentRelationReadDAO.findAll(po);
	}
	
}
	
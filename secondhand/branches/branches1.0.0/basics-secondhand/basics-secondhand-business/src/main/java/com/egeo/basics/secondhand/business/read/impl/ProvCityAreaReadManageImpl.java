package com.egeo.basics.secondhand.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.business.read.ProvCityAreaReadManage;
import com.egeo.basics.secondhand.dao.read.ProvCityAreaReadDAO;
import com.egeo.basics.secondhand.po.ProvCityAreaPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class ProvCityAreaReadManageImpl implements ProvCityAreaReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProvCityAreaReadDAO provCityAreaReadDAO;
	
	public ProvCityAreaPO findProvCityAreaById(ProvCityAreaPO po) {
		ProvCityAreaPO provCityAreapo = new ProvCityAreaPO();
		provCityAreapo.setId(po.getId());
		return provCityAreaReadDAO.findById(provCityAreapo);
	}

	public PageResult<ProvCityAreaPO> findProvCityAreaOfPage(ProvCityAreaPO po, Pagination page) {
		
		PageResult<ProvCityAreaPO> pageResult = new PageResult<ProvCityAreaPO>();
		List<ProvCityAreaPO> list = null;

		int cnt = provCityAreaReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = provCityAreaReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<ProvCityAreaPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<ProvCityAreaPO> findProvCityAreaAll(ProvCityAreaPO po) {

		return provCityAreaReadDAO.findAll(po);
	}
	
}
	
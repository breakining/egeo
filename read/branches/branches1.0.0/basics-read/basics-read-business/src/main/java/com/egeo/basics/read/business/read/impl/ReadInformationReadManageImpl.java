package com.egeo.basics.read.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.read.ReadInformationReadManage;
import com.egeo.basics.read.condition.ReadInformationCondition;
import com.egeo.basics.read.dao.read.ReadInformationReadDAO;
import com.egeo.basics.read.po.ReadInformationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class ReadInformationReadManageImpl implements ReadInformationReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ReadInformationReadDAO readInformationReadDAO;
	
	public ReadInformationPO findReadInformationById(ReadInformationPO po) {
		ReadInformationPO readInformationpo = new ReadInformationPO();
		readInformationpo.setId(po.getId());
		return readInformationReadDAO.findById(readInformationpo);
	}

	public PageResult<ReadInformationPO> findReadInformationOfPage(ReadInformationPO po, Pagination page) {
		
		PageResult<ReadInformationPO> pageResult = new PageResult<ReadInformationPO>();
		List<ReadInformationPO> list = null;

		int cnt = readInformationReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = readInformationReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<ReadInformationPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<ReadInformationPO> findReadInformationAll(ReadInformationPO po) {

		return readInformationReadDAO.findAll(po);
	}
	/**
	 * 根据userId查询悦读未读消息数量
	 * @param userId
	 * @return
	 */
	@Override
	public int cntById(Long userId) {
		// TODO Auto-generated method stub
		return readInformationReadDAO.cntById(userId);
	}
	/**
	 * 根据userId查询悦读消息
	 * @param userId
	 * @return
	 */
	@Override
	public PageResult<ReadInformationCondition> readInformationByUserId(ReadInformationPO po, Pagination page) {
		PageResult<ReadInformationCondition> pageResult = new PageResult<ReadInformationCondition>();
		List<ReadInformationCondition> list = null;

		int cnt = readInformationReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = readInformationReadDAO.readInformationByUserId(po, page);
		} else {
			list = new ArrayList<ReadInformationCondition>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;
	}
	
}
	
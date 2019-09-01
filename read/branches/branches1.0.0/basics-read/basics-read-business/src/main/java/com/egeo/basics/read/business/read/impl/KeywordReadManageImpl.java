package com.egeo.basics.read.business.read.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.read.KeywordReadManage;
import com.egeo.basics.read.dao.read.KeywordReadDAO;
import com.egeo.basics.read.po.KeywordPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class KeywordReadManageImpl implements KeywordReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KeywordReadDAO keywordReadDAO;
	
	public KeywordPO findKeywordById(KeywordPO po) {
		KeywordPO keywordpo = new KeywordPO();
		keywordpo.setId(po.getId());
		return keywordReadDAO.findById(keywordpo);
	}

	public PageResult<KeywordPO> findKeywordOfPage(KeywordPO po, Pagination page) {
		
		PageResult<KeywordPO> pageResult = new PageResult<KeywordPO>();
		List<KeywordPO> list = null;

		int cnt = keywordReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = keywordReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<KeywordPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<KeywordPO> findKeywordAll(KeywordPO po) {

		return keywordReadDAO.findAll(po);
	}
	
}
	
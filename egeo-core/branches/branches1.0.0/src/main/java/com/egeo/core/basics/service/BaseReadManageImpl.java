package com.egeo.core.basics.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.egeo.core.common.PageResult;
import com.egeo.core.orm.BaseReadDAO;
import com.egeo.core.orm.Pagination;
/**
 * ReadService基类
 * @author xiaping
 * @version 
 * @param <T>
 */
public  class BaseReadManageImpl<D extends BaseReadDAO<T>, T> implements BaseReadManage<T>  {
	public Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/**
	 * 持久层对象
	 * 
	 */
	
//	@Autowired
	public D dao;
	
	

	
	public void setDao(D dao) {
		this.dao = dao;
	}


	public T findById(T po) {
		return dao.findById(po);
	}


	public PageResult<T> findOfPage(T po, Pagination page) {
		
		PageResult<T> pageResult = new PageResult<T>();
		List<T> list = null;

		int cnt = dao.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = dao.findOfPage(po, page);
		} else {
			list = new ArrayList<T>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}


	public int countOfPage(T po) {
		return dao.countOfPage(po);
	}


	public List<T> findAll(T po) {
		return dao.findAll(po);
	}
	

	
}

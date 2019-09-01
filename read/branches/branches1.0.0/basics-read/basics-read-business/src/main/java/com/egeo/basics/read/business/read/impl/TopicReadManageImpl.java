package com.egeo.basics.read.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.read.TopicReadManage;
import com.egeo.basics.read.condition.TopicCondition;
import com.egeo.basics.read.dao.read.TopicReadDAO;
import com.egeo.basics.read.po.TopicPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class TopicReadManageImpl implements TopicReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TopicReadDAO topicReadDAO;
	
	public TopicPO findTopicById(TopicPO po) {
		TopicPO topicpo = new TopicPO();
		topicpo.setId(po.getId());
		return topicReadDAO.findById(topicpo);
	}

	public PageResult<TopicPO> findTopicOfPage(TopicPO po, Pagination page) {
		
		PageResult<TopicPO> pageResult = new PageResult<TopicPO>();
		List<TopicPO> list = null;

		int cnt = topicReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = topicReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<TopicPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<TopicPO> findTopicAll(TopicPO po) {

		return topicReadDAO.findAll(po);
	}
	/**
	 * 福管+app分页查询悦评
	 * @param vo
	 * @param page
	 * @param req
	 * @return
	 */
	@Override
	public PageResult<TopicCondition> topicOfPageApp(TopicPO po, Pagination page) {
		PageResult<TopicCondition> pageResult = new PageResult<TopicCondition>();
		List<TopicCondition> list = null;
		//查询所有topic的数量
		int cnt = topicReadDAO.countOfPage(po);
		//如果所有topic的数量>=本页的第一个topic的角标。
		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			//设置分页信息的角标
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = topicReadDAO.topicOfPageApp(po, page);
		} else {
			//封装一个空的对象
			list = new ArrayList<TopicCondition>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;
	}

	@Override
	public TopicCondition topicByIdApp(TopicPO po) {
		// TODO Auto-generated method stub
		return topicReadDAO.topicByIdApp(po);
	}
	
}
	
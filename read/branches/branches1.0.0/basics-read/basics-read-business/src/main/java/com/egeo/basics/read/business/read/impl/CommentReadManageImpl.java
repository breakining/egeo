package com.egeo.basics.read.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.read.CommentReadManage;
import com.egeo.basics.read.condition.CommentCondition;
import com.egeo.basics.read.dao.read.CommentReadDAO;
import com.egeo.basics.read.po.CommentPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class CommentReadManageImpl implements CommentReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommentReadDAO commentReadDAO;
	
	public CommentPO findCommentById(CommentPO po) {
		CommentPO commentpo = new CommentPO();
		commentpo.setId(po.getId());
		return commentReadDAO.findById(commentpo);
	}

	public PageResult<CommentPO> findCommentOfPage(CommentPO po, Pagination page) {
		
		PageResult<CommentPO> pageResult = new PageResult<CommentPO>();
		List<CommentPO> list = null;

		int cnt = commentReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = commentReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<CommentPO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<CommentPO> findCommentAll(CommentPO po) {

		return commentReadDAO.findAll(po);
	}
	/**
	 * 根据悦评id分页查询所有评论信息
	 */
	@Override
	public PageResult<CommentCondition> commentAllByTopicId(Long topicId, Pagination page) {
		CommentPO po = new CommentPO();
		po.setTopicId(topicId);
		PageResult<CommentCondition> pageResult = new PageResult<CommentCondition>();
		List<CommentCondition> list = null;

		int cnt = commentReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = commentReadDAO.commentAllByTopicId(topicId, page);
		} else {
			list = new ArrayList<CommentCondition>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;
	}
	
}
	
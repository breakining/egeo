package com.egeo.basics.read.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.read.condition.CommentCondition;
import com.egeo.basics.read.po.CommentPO;
import com.egeo.core.orm.BaseReadDAO;
import com.egeo.core.orm.Pagination;

public interface CommentReadDAO extends BaseReadDAO<CommentPO>{
	/**
	 * 根据悦评id查询所有评论信息
	 * @param topicId
	 * @return
	 */
	List<CommentCondition> commentAllByTopicId(@Param("topicId")Long topicId, @Param("page")Pagination page);
}
	
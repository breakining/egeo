package com.egeo.basics.read.api.read;


import java.util.List;

import com.egeo.basics.read.model.dto.CommentDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CommentReadService {

	public CommentDTO findCommentById(CommentDTO dto);

	public PageResult<CommentDTO> findCommentOfPage(CommentDTO dto,Pagination page);

	public List<CommentDTO> findCommentAll(CommentDTO dto);
	/**
	 * 根据悦评id查询所有评论信息
	 * @param topicId
	 * @return
	 */
	public PageResult<CommentDTO> commentAllByTopicId(Long topicId, Pagination page);
}
	
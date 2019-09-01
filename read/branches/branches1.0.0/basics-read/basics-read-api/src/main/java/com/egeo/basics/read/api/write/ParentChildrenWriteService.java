package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.ParentChildrenDTO;


public interface ParentChildrenWriteService {

	public Long insertParentChildrenWithTx(ParentChildrenDTO dto);

	public int updateParentChildrenWithTx(ParentChildrenDTO dto);

	public int deleteParentChildrenWithTx(ParentChildrenDTO dto);
	/**
	 * 根据子评论id删除关系
	 * @param id
	 * @return
	 */
	public int deleteByCommentIdWithTx(Long commentId);
}
	
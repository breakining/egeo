package com.egeo.basics.read.business.write;

import com.egeo.basics.read.po.ParentChildrenPO;


public interface ParentChildrenWriteManage {

	Long insertParentChildrenWithTx(ParentChildrenPO po);

	int updateParentChildrenWithTx(ParentChildrenPO po);

	int deleteParentChildrenWithTx(ParentChildrenPO po);
	/**
	 * 根据子评论id删除关系
	 * @param id
	 * @return
	 */
	int deleteByCommentIdWithTx(Long commentId);
}
	
package com.egeo.basics.read.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.write.ParentChildrenWriteManage;
import com.egeo.basics.read.dao.write.ParentChildrenWriteDAO;
import com.egeo.basics.read.po.ParentChildrenPO;
import com.egeo.core.exception.BusinessException;

@Service
public class ParentChildrenWriteManageImpl implements ParentChildrenWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ParentChildrenWriteDAO parentChildrenWriteDAO;

	@Override
	public Long insertParentChildrenWithTx(ParentChildrenPO po) {
		
		int i ;
		try {
				i = parentChildrenWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateParentChildrenWithTx(ParentChildrenPO po) {
		int i;
		i = parentChildrenWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteParentChildrenWithTx(ParentChildrenPO po) {
		int i;
		i = parentChildrenWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}

	@Override
	public int deleteByCommentIdWithTx(Long commentId) {
		ParentChildrenPO po = new ParentChildrenPO();
		po.setChildId(commentId);
		int i;
		i = parentChildrenWriteDAO.deleteByPara(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	
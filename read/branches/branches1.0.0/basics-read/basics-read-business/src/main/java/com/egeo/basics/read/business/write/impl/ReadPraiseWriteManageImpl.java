package com.egeo.basics.read.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.write.ReadPraiseWriteManage;
import com.egeo.basics.read.dao.write.ReadPraiseWriteDAO;
import com.egeo.basics.read.po.ReadPraisePO;
import com.egeo.core.exception.BusinessException;

@Service
public class ReadPraiseWriteManageImpl implements ReadPraiseWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ReadPraiseWriteDAO readPraiseWriteDAO;

	@Override
	public Long insertReadPraiseWithTx(ReadPraisePO po) {
		
		int i ;
		try {
				i = readPraiseWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateReadPraiseWithTx(ReadPraisePO po) {
		int i;
		i = readPraiseWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteReadPraiseWithTx(ReadPraisePO po) {
		int i;
		i = readPraiseWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	
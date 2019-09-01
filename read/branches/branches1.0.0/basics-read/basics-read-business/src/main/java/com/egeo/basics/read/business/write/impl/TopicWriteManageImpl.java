package com.egeo.basics.read.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.business.write.TopicWriteManage;
import com.egeo.basics.read.dao.write.TopicWriteDAO;
import com.egeo.basics.read.po.TopicPO;
import com.egeo.core.exception.BusinessException;

@Service
public class TopicWriteManageImpl implements TopicWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TopicWriteDAO topicWriteDAO;

	@Override
	public Long insertTopicWithTx(TopicPO po) {
		
		int i ;
		try {
				i = topicWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateTopicWithTx(TopicPO po) {
		int i;
		i = topicWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteTopicWithTx(TopicPO po) {
		int i;
		i = topicWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	
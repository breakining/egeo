package com.egeo.basics.secondhand.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.business.write.CommodityWriteManage;
import com.egeo.basics.secondhand.dao.write.CommodityWriteDAO;
import com.egeo.basics.secondhand.po.CommodityPO;
import com.egeo.core.exception.BusinessException;

@Service
public class CommodityWriteManageImpl implements CommodityWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommodityWriteDAO commodityWriteDAO;

	@Override
	public Long insertCommodityWithTx(CommodityPO po) {
		
		int i ;
		try {
				i = commodityWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateCommodityWithTx(CommodityPO po) {
		int i;
		i = commodityWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteCommodityWithTx(CommodityPO po) {
		int i;
		i = commodityWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	
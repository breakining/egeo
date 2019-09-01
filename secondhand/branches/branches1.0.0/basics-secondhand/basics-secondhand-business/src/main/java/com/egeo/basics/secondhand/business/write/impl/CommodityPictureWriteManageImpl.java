package com.egeo.basics.secondhand.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.business.write.CommodityPictureWriteManage;
import com.egeo.basics.secondhand.dao.write.CommodityPictureWriteDAO;
import com.egeo.basics.secondhand.po.CommodityPicturePO;
import com.egeo.core.exception.BusinessException;

@Service
public class CommodityPictureWriteManageImpl implements CommodityPictureWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommodityPictureWriteDAO commodityPictureWriteDAO;

	@Override
	public Long insertCommodityPictureWithTx(CommodityPicturePO po) {
		
		int i ;
		try {
				i = commodityPictureWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateCommodityPictureWithTx(CommodityPicturePO po) {
		int i;
		i = commodityPictureWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteCommodityPictureWithTx(CommodityPicturePO po) {
		int i;
		i = commodityPictureWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	
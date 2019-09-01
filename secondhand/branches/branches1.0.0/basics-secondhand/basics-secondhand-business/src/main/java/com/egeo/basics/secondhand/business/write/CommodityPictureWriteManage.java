package com.egeo.basics.secondhand.business.write;

import com.egeo.basics.secondhand.po.CommodityPicturePO;


public interface CommodityPictureWriteManage {

	Long insertCommodityPictureWithTx(CommodityPicturePO po);

	int updateCommodityPictureWithTx(CommodityPicturePO po);

	int deleteCommodityPictureWithTx(CommodityPicturePO po);
}
	
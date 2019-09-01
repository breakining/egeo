package com.egeo.basics.secondhand.business.read;

import java.util.List;

import com.egeo.basics.secondhand.condition.CommodityPictureCondition;
import com.egeo.basics.secondhand.po.CommodityPicturePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface CommodityPictureReadManage {

	public CommodityPicturePO findCommodityPictureById(CommodityPicturePO po);

	public PageResult<CommodityPicturePO> findCommodityPictureOfPage(CommodityPicturePO po,Pagination page);

	public List<CommodityPicturePO> findCommodityPictureAll(CommodityPicturePO po);
	/**
	 * 根据商品id查询商品图片
	 * @param commodityId
	 * @return
	 */
	public List<CommodityPictureCondition> commodityPictureByCommodityId(Long commodityId);
}
	
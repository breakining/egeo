package com.egeo.basics.secondhand.business.read;

import java.util.List;

import com.egeo.basics.secondhand.condition.CommodityCondition;
import com.egeo.basics.secondhand.po.CommodityPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface CommodityReadManage {

	public CommodityPO findCommodityById(CommodityPO po);

	public PageResult<CommodityPO> findCommodityOfPage(CommodityPO po,Pagination page);

	public List<CommodityPO> findCommodityAll(CommodityPO po);
	/**
	 * 分页查询所有二手商品
	 * @param page
	 * @return
	 */
	public PageResult<CommodityCondition> commodityOfPageApp(CommodityPO po,Pagination page);
}
	
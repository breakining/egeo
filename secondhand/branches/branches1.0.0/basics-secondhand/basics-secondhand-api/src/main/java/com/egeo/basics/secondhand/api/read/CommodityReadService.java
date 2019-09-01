package com.egeo.basics.secondhand.api.read;


import java.util.List;

import com.egeo.basics.secondhand.model.dto.CommodityDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CommodityReadService {

	public CommodityDTO findCommodityById(CommodityDTO dto);

	public PageResult<CommodityDTO> findCommodityOfPage(CommodityDTO dto,Pagination page);

	public List<CommodityDTO> findCommodityAll(CommodityDTO dto);
	/**
	 * 分页查询所有二手商品
	 * @param page
	 * @return
	 */
	public PageResult<CommodityDTO> commodityOfPageApp(CommodityDTO dto,Pagination page);
}
	
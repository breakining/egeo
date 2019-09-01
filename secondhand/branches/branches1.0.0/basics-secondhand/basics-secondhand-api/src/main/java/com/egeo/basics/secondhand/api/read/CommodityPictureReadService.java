package com.egeo.basics.secondhand.api.read;


import java.util.List;

import com.egeo.basics.secondhand.model.dto.CommodityPictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CommodityPictureReadService {

	public CommodityPictureDTO findCommodityPictureById(CommodityPictureDTO dto);

	public PageResult<CommodityPictureDTO> findCommodityPictureOfPage(CommodityPictureDTO dto,Pagination page);

	public List<CommodityPictureDTO> findCommodityPictureAll(CommodityPictureDTO dto);
	/**
	 * 根据商品id查询商品图片
	 * @param commodityId
	 * @return
	 */
	public List<CommodityPictureDTO> commodityPictureByCommodityId(Long commodityId);
}
	
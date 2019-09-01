package com.egeo.basics.secondhand.api.write;

import com.egeo.basics.secondhand.model.dto.CommodityDTO;


public interface CommodityWriteService {

	public Long insertCommodityWithTx(CommodityDTO dto);

	public int updateCommodityWithTx(CommodityDTO dto);

	public int deleteCommodityWithTx(CommodityDTO dto);
}
	
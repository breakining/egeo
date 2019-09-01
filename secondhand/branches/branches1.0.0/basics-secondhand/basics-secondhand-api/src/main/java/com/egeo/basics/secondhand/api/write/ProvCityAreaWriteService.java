package com.egeo.basics.secondhand.api.write;

import com.egeo.basics.secondhand.model.dto.ProvCityAreaDTO;


public interface ProvCityAreaWriteService {

	public Long insertProvCityAreaWithTx(ProvCityAreaDTO dto);

	public int updateProvCityAreaWithTx(ProvCityAreaDTO dto);

	public int deleteProvCityAreaWithTx(ProvCityAreaDTO dto);
}
	
package com.egeo.basics.secondhand.api.read;


import java.util.List;
	
import com.egeo.basics.secondhand.model.dto.ProvCityAreaDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface ProvCityAreaReadService {

	public ProvCityAreaDTO findProvCityAreaById(ProvCityAreaDTO dto);

	public PageResult<ProvCityAreaDTO> findProvCityAreaOfPage(ProvCityAreaDTO dto,Pagination page);

	public List<ProvCityAreaDTO> findProvCityAreaAll(ProvCityAreaDTO dto);
}
	
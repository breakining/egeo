package com.egeo.basics.secondhand.business.read;

import java.util.List;
	
import com.egeo.basics.secondhand.po.ProvCityAreaPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface ProvCityAreaReadManage {

	public ProvCityAreaPO findProvCityAreaById(ProvCityAreaPO po);

	public PageResult<ProvCityAreaPO> findProvCityAreaOfPage(ProvCityAreaPO po,Pagination page);

	public List<ProvCityAreaPO> findProvCityAreaAll(ProvCityAreaPO po);
}
	
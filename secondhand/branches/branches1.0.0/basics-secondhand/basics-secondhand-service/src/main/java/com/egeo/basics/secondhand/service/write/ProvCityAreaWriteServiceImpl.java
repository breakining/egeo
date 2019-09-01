package com.egeo.basics.secondhand.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.secondhand.api.write.ProvCityAreaWriteService;
import com.egeo.basics.secondhand.business.write.ProvCityAreaWriteManage;
import com.egeo.basics.secondhand.converter.ProvCityAreaConverter;
import com.egeo.basics.secondhand.model.dto.ProvCityAreaDTO;
import com.egeo.basics.secondhand.po.ProvCityAreaPO;

@Service("provCityAreaWriteService")
public class ProvCityAreaWriteServiceImpl extends BaseService implements ProvCityAreaWriteService {
	@Autowired
	private ProvCityAreaWriteManage provCityAreaWriteManage;

	@Override
	public Long insertProvCityAreaWithTx(ProvCityAreaDTO dto) {
		ProvCityAreaPO po = ProvCityAreaConverter.toPO(dto);
		Long rt = provCityAreaWriteManage.insertProvCityAreaWithTx(po);		
		return rt;
	}

	@Override
	public int updateProvCityAreaWithTx(ProvCityAreaDTO dto) {
		ProvCityAreaPO po = ProvCityAreaConverter.toPO(dto);
		int rt = provCityAreaWriteManage.updateProvCityAreaWithTx(po);		
		return rt;
	}

	@Override
	public int deleteProvCityAreaWithTx(ProvCityAreaDTO dto) {
		ProvCityAreaPO po = ProvCityAreaConverter.toPO(dto);
		int rt = provCityAreaWriteManage.deleteProvCityAreaWithTx(po);		
		return rt;
	}
}
	
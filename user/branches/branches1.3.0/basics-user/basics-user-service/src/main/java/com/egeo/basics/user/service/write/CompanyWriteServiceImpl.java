package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.CompanyWriteService;
import com.egeo.basics.user.business.write.CompanyWriteManage;
import com.egeo.basics.user.converter.CompanyConverter;
import com.egeo.basics.user.model.dto.CompanyDTO;

@Service("companyWriteService")
public class CompanyWriteServiceImpl extends BaseService implements CompanyWriteService {
	@Autowired
	private CompanyWriteManage companyWriteManage;

	@Override
	public Long saveWithTx(CompanyDTO dto) {
		// TODO Auto-generated method stub
		return companyWriteManage.saveWithTx(CompanyConverter.toPO(dto));
	}

	@Override
	public Integer deleteById(CompanyDTO dto) {
		// TODO Auto-generated method stub
		return companyWriteManage.deleteById(CompanyConverter.toPO(dto));
	}
}
	
package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.CompanyRoleWriteService;
import com.egeo.basics.user.business.write.CompanyRoleWriteManage;

@Service("companyRoleWriteService")
public class CompanyRoleWriteServiceImpl extends BaseService implements CompanyRoleWriteService {
	@Autowired
	private CompanyRoleWriteManage companyRoleWriteManage;
}
	
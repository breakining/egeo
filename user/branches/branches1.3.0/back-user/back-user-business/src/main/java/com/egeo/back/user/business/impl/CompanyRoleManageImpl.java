package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.CompanyRoleManage;
import com.egeo.back.user.facade.CompanyRoleFacade;

@Service("companyRole")
public class CompanyRoleManageImpl implements CompanyRoleManage{

	
	@Resource(name="companyRoleFacade")
	private CompanyRoleFacade companyRoleFacade;
	


}
	
package com.egeo.back.user.web.action;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.CompanyRoleManage;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;



@Controller
@RequestMapping("user/companyRole")
public class CompanyRoleAction extends BaseSpringController {
	
	@Resource(name="companyRole")
	private CompanyRoleManage companyRoleManage;
	
	
}
	
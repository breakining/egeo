package com.egeo.back.user.web.action;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.SysRoleManage;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;



@Controller
@RequestMapping("sysRole")
public class SysRoleAction extends BaseSpringController {
	
	@Resource(name="sysRole")
	private SysRoleManage sysRoleManage;
	
	
}
	
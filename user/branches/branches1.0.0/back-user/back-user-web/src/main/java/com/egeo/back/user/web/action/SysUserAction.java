package com.egeo.back.user.web.action;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.SysUserManage;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;



@Controller
@RequestMapping("sysUser")
public class SysUserAction extends BaseSpringController {
	
	@Resource(name="sysUser")
	private SysUserManage sysUserManage;
	
	
}
	
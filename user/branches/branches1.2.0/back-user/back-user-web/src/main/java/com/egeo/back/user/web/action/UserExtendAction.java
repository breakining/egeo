package com.egeo.back.user.web.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egeo.back.user.business.UserExtendManage;
import com.egeo.core.web.BaseSpringController;



@Controller
@RequestMapping("userExtend")
public class UserExtendAction extends BaseSpringController {
	
	@Resource(name="userExtend")
	private UserExtendManage userExtendManage;
	

}
	
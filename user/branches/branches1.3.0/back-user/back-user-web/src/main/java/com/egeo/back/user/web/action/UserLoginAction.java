package com.egeo.back.user.web.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egeo.back.user.business.UserLoginManage;
import com.egeo.core.web.BaseSpringController;



@Controller
@RequestMapping("user/userLogin")
public class UserLoginAction extends BaseSpringController {
	
	@Resource(name="userLogin")
	private UserLoginManage userLoginManage;
	

}
	
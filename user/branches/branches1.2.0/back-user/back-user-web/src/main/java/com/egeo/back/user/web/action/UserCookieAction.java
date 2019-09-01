package com.egeo.back.user.web.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egeo.back.user.business.UserCookieManage;
import com.egeo.core.web.BaseSpringController;



@Controller
@RequestMapping("userCookie")
public class UserCookieAction extends BaseSpringController {
	
	@Resource(name="userCookie")
	private UserCookieManage userCookieManage;
	
	
}
	
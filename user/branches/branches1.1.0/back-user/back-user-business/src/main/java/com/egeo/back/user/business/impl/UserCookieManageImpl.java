package com.egeo.back.user.business.impl;
	

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserCookieManage;
import com.egeo.back.user.converter.UserCookieConverter;
import com.egeo.back.user.facade.UserCookieFacade;
import com.egeo.back.user.model.vo.UserCookieVO;

@Service("userCookie")
public class UserCookieManageImpl implements UserCookieManage{

	
	@Resource(name="userCookieFacade")
	private UserCookieFacade userCookieFacade;

	@Override
	public void saveUserCookieWithTx(UserCookieVO userCookie) {
		// TODO Auto-generated method stub

        //设置有效时间
        // 生成失效时间
        Calendar timeout = Calendar.getInstance();
        timeout.setTime(new Date());
        timeout.add(Calendar.DAY_OF_YEAR, 30);
        userCookie.setExpirationTime(timeout.getTime());

        userCookieFacade.saveUserCookieWithTx(UserCookieConverter.toDTO(userCookie));
    
		
	}
	


}
	
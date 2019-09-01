package com.egeo.back.user.business.impl;
	

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserCookieManage;
import com.egeo.back.user.business.util.CommonUtils;
import com.egeo.back.user.converter.UserCookieConverter;
import com.egeo.back.user.facade.UserCookieFacade;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.basics.user.model.dto.UserCookieDTO;

@Service("userCookie")
public class UserCookieManageImpl implements UserCookieManage{

	
	@Resource(name="userCookieFacade")
	private UserCookieFacade userCookieFacade;

	@Override
	public void saveUserCookieWithTx(UserCookieVO userCookie,HttpServletRequest req) {
		// TODO Auto-generated method stub

		CacheUser cacheUser = (CacheUser) req.getAttribute("ut");
        //设置有效时间
        // 生成失效时间
        Calendar timeout = Calendar.getInstance();
        timeout.setTime(new Date());
        timeout.add(Calendar.DAY_OF_YEAR, 30);
        userCookie.setExpirationTime(timeout.getTime());
        
        UserCookieDTO userCookieDTO = userCookieFacade.getbyUserId(userCookie.getUserId());
        if(userCookieDTO == null){
			userCookie.setCreateTime(new Date());		
			String ip = CommonUtils.getUserIp(req);
			userCookie.setCreateUserip(ip);
			userCookie.setCreateUsermac(CommonUtils.getMACAddress(ip));
			userCookie.setCreateUsername(cacheUser.getName());
        	userCookieFacade.saveUserCookieWithTx(UserCookieConverter.toDTO(userCookie));
        }else{
        	userCookie.setUpdateTime(new Date());
        	String ip = CommonUtils.getUserIp(req);
        	userCookie.setUpdateUserip(ip);
        	userCookie.setUpdateUsermac(CommonUtils.getMACAddress(ip));
        	userCookie.setUpdateUsername(cacheUser.getName());
        	userCookieFacade.saveUserCookieWithTx(UserCookieConverter.toDTO(userCookie));
        }

        
    
		
	}

	@Override
	public UserCookieDTO getbyUserId(Long id) {
		// TODO Auto-generated method stub
		return userCookieFacade.getbyUserId(id);
	}
	


}
	
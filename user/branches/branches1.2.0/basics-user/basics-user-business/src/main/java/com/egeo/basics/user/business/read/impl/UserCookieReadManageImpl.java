package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserCookieReadManage;
import com.egeo.basics.user.dao.read.UserCookieReadDAO;
import com.egeo.basics.user.po.UserCookiePO;

@Service
public class UserCookieReadManageImpl implements UserCookieReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserCookieReadDAO userCookieReadDAO;
	@Override
	public UserCookiePO getbyUserId(Long userId) {
		// TODO Auto-generated method stub
		UserCookiePO po = new UserCookiePO();
		po.setUserId(userId);
		List<UserCookiePO> poList = userCookieReadDAO.findAll(po);
		if(poList == null){
			return null;
		}else{
			return poList.get(0);
		}
	}
	
}
	
package com.egeo.basics.user.business.read.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserLoginReadManage;
import com.egeo.basics.user.dao.read.UserLoginReadDAO;

@Service
public class UserLoginReadManageImpl implements UserLoginReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserLoginReadDAO userLoginReadDAO;
	
}
	
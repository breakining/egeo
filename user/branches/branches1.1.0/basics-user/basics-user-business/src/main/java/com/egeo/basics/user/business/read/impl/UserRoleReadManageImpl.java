package com.egeo.basics.user.business.read.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserRoleReadManage;
import com.egeo.basics.user.dao.read.UserRoleReadDAO;

@Service
public class UserRoleReadManageImpl implements UserRoleReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRoleReadDAO userRoleReadDAO;
	
}
	